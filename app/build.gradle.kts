plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
    id ("com.google.gms.google-services")
//    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.magicenglish"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.magicenglish"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui:")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
    implementation ("androidx.compose.foundation:foundation:1.0.0")

    // System ui controller
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.27.0")

    //icons
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.compose.material:material-icons-core:<latest_version>")
    implementation("androidx.compose.material:material-icons-extended:<latest_version>")

    //lottie animation
    implementation("com.airbnb.android:lottie-compose:6.0.1")
    implementation("io.coil-kt:coil-compose:1.4.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")

    //navigation
    implementation("androidx.navigation:navigation-fragment-compose:2.8.0-alpha07")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-compose:2.7.7")

    //room
    val room_version = "2.3.0"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation ("androidx.room:room-ktx:2.3.0")


    // Firebase
    implementation ("com.google.firebase:firebase-auth-ktx:22.0.0")
    implementation ("com.google.firebase:firebase-firestore-ktx:24.6.0")
    implementation("com.google.android.gms:play-services-auth:20.4.1")
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation( "com.google.accompanist:accompanist-permissions:0.21.1-beta")

    //viewmodel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
    implementation( "androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")


    // Dagger-Hilt
    implementation ("com.google.dagger:hilt-android:2.49")
    kapt ("com.google.dagger:hilt-android-compiler:2.44")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")


}