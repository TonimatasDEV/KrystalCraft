@file:Suppress("DEPRECATION")

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

val minecraftVersion: String by extra
val neoforgeVersion: String by extra
val neoforgeLoaderRange: String by extra
val modVersion: String by extra
val jeiVersion: String by extra
val resourcefullibVersion: String by extra
val resourcefullibRange: String by extra
val botariumVersion: String by extra
val botariumRange: String by extra

architectury {
    platformSetupLoomIde()
    neoForge()
}

val common by configurations.creating
val shadowCommon by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentNeoForge"].extendsFrom(common)

repositories {
    maven(url = "https://maven.neoforged.net/")
}

dependencies {
    neoForge("net.neoforged:neoforge:$neoforgeVersion")


    modApi("com.teamresourceful.resourcefullib:resourcefullib-neoforge-$minecraftVersion:$resourcefullibVersion")
    modApi("earth.terrarium.botarium:botarium-neoforge-$minecraftVersion:$botariumVersion")

    modCompileOnly("mezz.jei:jei-$minecraftVersion-neoforge-api:$jeiVersion")
    modLocalRuntime("mezz.jei:jei-$minecraftVersion-forge:$jeiVersion") { isTransitive = false }

    common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionNeoForge")) { isTransitive = false }
}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("neoforgeLoaderRange" to neoforgeLoaderRange, "minecraftVersion" to minecraftVersion, "modVersion" to modVersion, "resourcefullibRange" to resourcefullibRange, "botariumRange" to botariumRange)
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
