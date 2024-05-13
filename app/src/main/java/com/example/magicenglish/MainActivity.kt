package com.example.magicenglish

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.magicenglish.bigineer_app_screens.presentation.profile.ProfileScreen
import com.example.magicenglish.bigineer_app_screens.presentation.sign_in.GoogleAuthUiClient
import com.example.magicenglish.bigineer_app_screens.presentation.sign_in.SignInScreen
import com.example.magicenglish.bigineer_app_screens.presentation.sign_in.SignInViewModel
import com.example.magicenglish.ui.theme.MagicEnglishTheme
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MagicEnglishTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "sign_in") {
                        composable("sign_in") {
                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            LaunchedEffect(key1 = Unit) {
                                if(googleAuthUiClient.getSignedInUser() != null) {
                                    navController.navigate("profile")
                                }
                            }

                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if(result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )

                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if(state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign in successful",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    navController.navigate("profile")
                                    viewModel.resetState()
                                }
                            }

                            SignInScreen(
                                state = state,
                                onSignInClick = {
                                    lifecycleScope.launch {
                                        val signInIntentSender = googleAuthUiClient.signIn()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                                signInIntentSender ?: return@launch
                                            ).build()
                                        )
                                    }
                                }
                            )
                        }
                        composable("profile") {
                            ProfileScreen(
                                userData = googleAuthUiClient.getSignedInUser(),
                                onSignOut = {
                                    lifecycleScope.launch {
                                        googleAuthUiClient.signOut()
                                        Toast.makeText(
                                            applicationContext,
                                            "Signed out",
                                            Toast.LENGTH_LONG
                                        ).show()

                                        navController.popBackStack()
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

//            val context = this@MainActivity
//            val isLoading = remember { mutableStateOf(false) }
//            val isError = remember { mutableStateOf(false) }
//            val composition by rememberLottieComposition(
//                spec = LottieCompositionSpec.RawRes(R.raw.splach_screen)
//            )
//
//            val progress by animateLottieCompositionAsState(
//                composition = composition,
//                iterations = LottieConstants.IterateForever
//            )
//            LaunchedEffect(key1 = true) {
//                if (isNetworkAvailable(context)) {
//                    try {
//                        isLoading.value = true
//                        delay(3000)
//                        isLoading.value = false
//                    } catch (e: Exception) {
//                        isError.value = true
//                        isLoading.value = false
//                    }
//                } else {
//                    isError.value = true
//                }
//            }
//            if (isLoading.value) {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    LottieAnimation(
////                        modifier = Modifier.size(150.dp),
//                        composition = composition,
//                        progress = { progress }
//                    )
//                }
//            } else if (isError.value) {
//                AlertDialog(
//                    onDismissRequest = {
//                        // Закрытие диалога
//                        isError.value = false
//                    },
//                    title = {
//                        Text(text = "Error loading data")
//                    },
//                    text = {
//                        Text(text = "An error occurred while uploading the data.\nPlease check your internet connection and try again.")
//                    },
//                    confirmButton = {
//                        Button(
//                            onClick = {
//                                // Повторная попытка загрузки данных
//                                isError.value = false
//                                if (isNetworkAvailable(context)) {
//                                    isLoading.value = true
//                                } else {
//                                    isError.value = true
//                                }
//                            }
//                        ) {
//                            Text("Replay")
//                        }
//                    }
//                )
//            } else {
////                val intent = Intent(this,BeginScreenActivity::class.java)
////                startActivity(intent)
//                BeginScreen()
//            }
//        }
//    }
//}
//fun isNetworkAvailable(context : Context):Boolean{
//    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    val networkInfo = connectivityManager.activeNetworkInfo
//    return networkInfo != null && networkInfo.isConnected
//}