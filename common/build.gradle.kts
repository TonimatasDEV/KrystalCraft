val minecraftVersion: String by extra
val fabricLoaderVersion: String by extra
val botariumVersion: String by extra
val resourcefullibVersion: String by extra
val jeiVersion: String by extra
val reiVersion: String by extra

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")

    modApi(files("../libs/MythLib-common-1.0.0.jar"))

    modCompileOnly("mezz.jei:jei-$minecraftVersion-common-api:$jeiVersion")
    modRuntimeOnly("mezz.jei:jei-$minecraftVersion-common:$jeiVersion")
    //modCompileOnly("me.shedaniel:RoughlyEnoughItems-api:$reiVersion")
    //modCompileOnly("me.shedaniel:RoughlyEnoughItems-default-plugin:$reiVersion")
}

architectury {
    common("fabric", "forge")
}
