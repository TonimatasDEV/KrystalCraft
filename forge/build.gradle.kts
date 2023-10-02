@file:Suppress("DEPRECATION", "UnstableApiUsage")

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

architectury {
    platformSetupLoomIde()
    forge()
}

loom {
    forge {
        mixinConfig("krystalcraft-common.mixins.json")
        mixinConfig("krystalcraft.mixins.json")
    }
}

val minecraftVersion: String by extra
val forgeVersion: String by extra
val forgeLoaderRange: String by extra
val botariumVersion: String by extra
val modVersion: String by extra
val jeiVersion: String by extra

val common: Configuration by configurations.creating
val shadowCommon: Configuration by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentForge"].extendsFrom(common)

dependencies {
    forge("net.minecraftforge:forge:$forgeVersion")

    modCompileOnly("mezz.jei:jei-${minecraftVersion}-forge-api:${jeiVersion}")
    modLocalRuntime("mezz.jei:jei-${minecraftVersion}-forge:${jeiVersion}") { isTransitive = false }

    common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionForge")) { isTransitive = false }
}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf(
        "modVersion" to modVersion, "forgeLoaderRange" to forgeLoaderRange, "minecraftVersion" to minecraftVersion)
    inputs.properties(replaceProperties)

    filesMatching("META-INF/mods.toml") {
        expand(replaceProperties)
    }
}

tasks.withType<ShadowJar> {
    exclude("fabric.mod.json")

    configurations = listOf(shadowCommon)
    archiveClassifier.set("dev-shadow")
}

tasks.withType<RemapJarTask> {
    val shadowTask = tasks.shadowJar.get()
    input.set(shadowTask.archiveFile)
    dependsOn(shadowTask)
    archiveClassifier.set("")
}

tasks.jar {
    archiveClassifier.set("dev")
}

tasks.sourcesJar {
    val commonSources = project(":common").tasks.sourcesJar.get()
    dependsOn(commonSources)
    from(commonSources.archiveFile.map { zipTree(it) })
}

components.getByName<AdhocComponentWithVariants>("java").apply {
    withVariantsFromConfiguration(project.configurations["shadowRuntimeElements"]) {
        skip()
    }
}

sourceSets {
    main {
        resources.srcDirs("src/data/resources")
    }
}