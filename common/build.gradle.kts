val minecraftVersion: String by extra
val fabricLoaderVersion: String by extra
val jeiVersion: String by extra

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    
    modCompileOnly("mezz.jei:jei-$minecraftVersion-common-api:$jeiVersion")
    modRuntimeOnly("mezz.jei:jei-$minecraftVersion-common:$jeiVersion")
    //modCompileOnly("me.shedaniel:RoughlyEnoughItems-api:$reiVersion")
    //modCompileOnly("me.shedaniel:RoughlyEnoughItems-default-plugin:$reiVersion")
}

architectury {
    common("fabric", "neoforge")
}

loom {
    accessWidenerPath.set(file("src/main/resources/krystalcraft.accesswidener"))
}
