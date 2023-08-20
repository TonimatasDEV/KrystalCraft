val minecraftVersion: String by extra
val fabricLoaderVersion: String by extra
val botariumVersion: String by extra
val resourcefullibVersion: String by extra

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    modImplementation("earth.terrarium:botarium-common-$minecraftVersion:$botariumVersion")
    modImplementation("com.teamresourceful.resourcefullib:resourcefullib-common-$minecraftVersion:$resourcefullibVersion")

    //modCompileOnly "mezz.jei:jei-$minecraft_version-common-api:${jei_version}"
    //modRuntimeOnly "mezz.jei:jei-$minecraft_version-common:${jei_version}"
    //modCompileOnly "me.shedaniel:RoughlyEnoughItems-api:${rei_version}"
    //modCompileOnly "me.shedaniel:RoughlyEnoughItems-default-plugin:${rei_version}"
}

architectury {
    common("fabric", "forge")
}
