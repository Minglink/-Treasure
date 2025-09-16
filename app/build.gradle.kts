plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.treasure"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.treasure"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    //去除Netty的重复文件，在Gradle的构建中不准许存在重复文件
    packaging {
        resources {
            pickFirsts.add("META-INF/INDEX.LIST")
            pickFirsts.add("META-INF/io.netty.versions.properties")
            pickFirsts.add("META-INF/DEPENDENCIES")
            pickFirsts.add("META-INF/LICENSE")
            pickFirsts.add("META-INF/LICENSE.txt")
            pickFirsts.add("META-INF/NOTICE")
            pickFirsts.add("META-INF/NOTICE.txt")
        }
    }
}

dependencies {
    // 统一 lifecycle/fragment 版本，覆盖高德带来的旧版
    //implementation(platform("androidx.lifecycle:lifecycle-bom:2.6.1"))
    //implementation("androidx.fragment:fragment-ktx:1.6.2")

    //高德地图依赖
    implementation("com.amap.api:3dmap:10.0.600")
    //implementation("com.amap.api:location:6.4.5")
    implementation("com.amap.api:search:9.7.0")

    //网络请求库
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    //OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //Glide图像的加载与缓存
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    //room本地数据库
    val roomVersion="2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    //Firebase消息推送
    implementation (platform("com.google.firebase:firebase-bom:33.2.0"))
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.firebase:firebase-analytics")

    //Netty即时通讯
    implementation("io.netty:netty-all:4.1.113.Final")


    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}