import net.fabricmc.loom.api.LoomGradleExtensionAPI
import net.fabricmc.loom.task.RemapJarTask
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("dev.architectury.loom") version "1.7-SNAPSHOT" apply false
    id("com.gradleup.shadow") version "8.3.5" apply false
}

val minecraftVersion: String by extra
val modVersion: String by extra

architectury {
    minecraft = minecraftVersion
}

allprojects {
    version = modVersion
    group = "dev.tonimatas"

    repositories {
        maven("https://maven.neoforged.net")
        maven("https://maven.blamejared.com")
        maven("https://maven.resourcefulbees.com/repository/maven-public")
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "architectury-plugin")
    apply(plugin = "dev.architectury.loom")
    apply(plugin = "com.gradleup.shadow")

    base {
        archivesName.set("krystalcraft-" + project.name)
    }

    configure<LoomGradleExtensionAPI> {
        silentMojangMappingsLicense()
    }

    dependencies {
        "minecraft"("com.mojang:minecraft:$minecraftVersion")
        "mappings"(project.the<LoomGradleExtensionAPI>().officialMojangMappings())
    }

    tasks.withType<JavaCompile> {
        options.release.set(21)
    }

    java {
        withSourcesJar()
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))

        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    
    if (name == "fabric") {
        architectury {
            platformSetupLoomIde()
            fabric()
        }
    }
    
    if (name == "neoforge") {
        architectury {
            platformSetupLoomIde()
            neoForge()
        }
    }

    val architecturyVersion: String by extra
    val rlMinecraftVersion: String by extra
    
    dependencies {
        "modApi"("com.teamresourceful.resourcefullib:resourcefullib-$name-$rlMinecraftVersion:$architecturyVersion")
    }
    
    if (name != "common") {
        val loaderName = if (name == "fabric") "Fabric" else "NeoForge"
        
        val common: Configuration by configurations.creating
        val shadowCommon: Configuration by configurations.creating

        configurations["compileClasspath"].extendsFrom(common)
        configurations["runtimeClasspath"].extendsFrom(common)
        configurations["development$loaderName"].extendsFrom(common)
        
        dependencies {
            common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
            shadowCommon(project(path = ":common", configuration = "transformProduction$loaderName")) { isTransitive = false }
        }
        
        tasks.withType<ShadowJar> {
            configurations = listOf(shadowCommon)
            archiveClassifier.set("dev-shadow")
        }

        tasks.withType<RemapJarTask> {
            val shadowTask = tasks.getByName<ShadowJar>("shadowJar")
            inputFile.set(shadowTask.archiveFile)
            dependsOn(shadowTask)
            archiveClassifier.set("")
        }

        tasks.jar {
            archiveClassifier.set("dev")
        }

        components.getByName<AdhocComponentWithVariants>("java").apply {
            withVariantsFromConfiguration(project.configurations["shadowRuntimeElements"]) {
                skip()
            }
        }
    }
}
