val minecraftVersion: String by extra
val fabricLoaderVersion: String by extra
val botariumVersion: String by extra
val resourcefullibVersion: String by extra
val jeiVersion: String by extra

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")

    modCompileOnly("mezz.jei:jei-$minecraftVersion-common-api:${jeiVersion}")
    modRuntimeOnly("mezz.jei:jei-$minecraftVersion-common:${jeiVersion}")
    //modCompileOnly "me.shedaniel:RoughlyEnoughItems-api:${rei_version}"
    //modCompileOnly "me.shedaniel:RoughlyEnoughItems-default-plugin:${rei_version}"
}

architectury {
    common("fabric", "forge")
}
