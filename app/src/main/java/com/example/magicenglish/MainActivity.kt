package com.example.magicenglish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.magicenglish.log_in_screen.GoogleAuthUiClient
import com.example.magicenglish.vocabulary_trainer.DictionaryApp
import com.example.magicenglish.vocabulary_trainer.DictionaryApplication
import com.example.magicenglish.vocabulary_trainer.WordViewModel
import com.example.magicenglish.vocabulary_trainer.WordViewModelFactory
import com.google.android.gms.auth.api.identity.Identity


class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as DictionaryApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            MagicEnglishTheme {
            DictionaryApp(wordViewModel)
//                val navController = rememberNavController()
//                NavHost(navController = navController, startDestination = "sign_in") {
//                    composable("sign_in") {
//
//                        val viewModel = viewModel<SignInViewModel>()
//                        val state by viewModel.state.collectAsStateWithLifecycle()
//
//                        LaunchedEffect(key1 = Unit) {
//                            if (googleAuthUiClient.getSignedInUser() != null) {
//                                navController.navigate("main_screen")
//                            }
//                        }
//                        val launcher = rememberLauncherForActivityResult(
//                            contract = ActivityResultContracts.StartIntentSenderForResult(),
//                            onResult = { result ->
//                                if (result.resultCode == RESULT_OK) {
//                                    lifecycleScope.launch {
//                                        val signInResult = googleAuthUiClient.signInWithIntent(
//                                            intent = result.data ?: return@launch
//                                        )
//                                        viewModel.onSignInResult(signInResult)
//                                    }
//                                }
//                            }
//                        )
//                        LaunchedEffect(key1 = state.isSignInSuccessful) {
//                            if (state.isSignInSuccessful) {
//                                Toast.makeText(
//                                    applicationContext,
//                                    "Sign in successful",
//                                    Toast.LENGTH_LONG
//                                ).show()
//                                navController.navigate("main_screen")
//                                viewModel.resetState()
//                            }
//                        }
//                        LogInScreen(
//                            state = state,
//                            onSignInClick = {
//                                lifecycleScope.launch {
//                                    val signInIntentSender = googleAuthUiClient.signIn()
//                                    launcher.launch(
//                                        IntentSenderRequest.Builder(
//                                            signInIntentSender ?: return@launch
//                                        ).build()
//                                    )
//                                }
//                            }
//                        )
//                    }
//                    composable("main_screen") {
//                        ProfileScreen(
//                            userData = googleAuthUiClient.getSignedInUser(),
//                            onSignOut = {
//                                lifecycleScope.launch {
//                                    googleAuthUiClient.signOut()
//                                    Toast.makeText(
//                                        applicationContext,
//                                        "Signed out",
//                                        Toast.LENGTH_LONG
//                                    ).show()
//                                    navController.popBackStack()
//                                }
//                            }
//                        )
////                        MainScreen()
//                    }
//                }
            }
//        }
    }
}

