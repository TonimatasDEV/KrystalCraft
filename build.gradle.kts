plugins {
    id("fabric-loom") version "1.11-SNAPSHOT"
}

val minecraftVersion: String by extra
val loaderVersion: String by extra
val modVersion: String by extra
val fabricVersion: String by extra
val yarnMappings: String by extra
val jeiVersion: String by extra

version = modVersion
group = "dev.tonimatas.krystalcraft"

base {
    archivesName = "krystalcraft"
}

fabricApi {
    configureDataGeneration()
}

loom {
    splitEnvironmentSourceSets()

    mods {
        create("krystalcraft").apply {
            sourceSet(sourceSets.main.get())
            sourceSet(sourceSets.getByName("client"))
        }
    }
}

repositories {
    maven("https://maven.blamejared.com")
    maven("https://modmaven.dev")
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:$minecraftVersion+build.$yarnMappings:v2")
    
    // Fabric
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")
    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabricVersion")

    // Compatibility
    modCompileOnlyApi("mezz.jei:jei-$minecraftVersion-fabric-api:$jeiVersion")
    //modRuntimeOnly("mezz.jei:jei-$minecraftVersion-fabric:$jeiVersion")
}

tasks.processResources {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
        expand("version" to inputs.properties["version"])
    }
}

tasks.withType(JavaCompile::class).configureEach {
    options.release.set(21)
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.jar {
    inputs.property("archivesName", project.base.archivesName)

    from("LICENSE") {
        rename { "${it}_${inputs.properties["archivesName"]}"}
    }
}
