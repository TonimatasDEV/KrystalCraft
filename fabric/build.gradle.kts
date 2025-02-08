loom {
    accessWidenerPath.set(project(":common").loom.accessWidenerPath)
}

val minecraftVersion: String by extra
val fabricApiVersion: String by extra
val fabricLoaderVersion: String by extra
val fabricLoaderRange: String by extra
val architecturyRange: String by extra
val modVersion: String by extra


dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")

    //modRuntimeOnly "me.shedaniel:RoughlyEnoughItems-fabric:${rei_version}"
    //modCompileOnly "me.shedaniel:RoughlyEnoughItems-api-fabric:${rei_version}"
    //modCompileOnly "me.shedaniel:RoughlyEnoughItems-default-plugin-fabric:${rei_version}"
}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("modVersion" to modVersion, "fabricLoaderRange" to fabricLoaderRange, "minecraftVersion" to minecraftVersion, "architecturyRange" to architecturyRange)
    inputs.properties(replaceProperties)

    filesMatching("fabric.mod.json") {
        expand(replaceProperties)
    }
}

