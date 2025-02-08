loom {
    accessWidenerPath.set(project(":common").loom.accessWidenerPath)
}

val minecraftVersion: String by extra
val neoforgeVersion: String by extra
val neoforgeLoaderRange: String by extra
val modVersion: String by extra
val jeiVersion: String by extra
val architecturyRange: String by extra

dependencies {
    neoForge("net.neoforged:neoforge:$neoforgeVersion")

    modCompileOnly("mezz.jei:jei-$minecraftVersion-neoforge-api:$jeiVersion")
    modLocalRuntime("mezz.jei:jei-$minecraftVersion-forge:$jeiVersion") { isTransitive = false }

}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("neoforgeLoaderRange" to neoforgeLoaderRange, "minecraftVersion" to minecraftVersion, "modVersion" to modVersion, "architecturyRange" to architecturyRange)
    inputs.properties(replaceProperties)

    filesMatching("META-INF/neoforge.mods.toml") {
        expand(replaceProperties)
    }
}
