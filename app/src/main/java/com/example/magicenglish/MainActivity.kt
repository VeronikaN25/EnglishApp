package com.example.magicenglish

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.magicenglish.log_in_screen.GoogleAuthUiClient
import com.example.magicenglish.ui.theme.MagicEnglishTheme
import com.example.magicenglish.vocabulary_trainer.presentation.WordInfoItem
import com.example.magicenglish.vocabulary_trainer.presentation.WordInfoViewModel
import com.google.android.gms.auth.api.identity.Identity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MagicEnglishTheme {
                val viewModel : WordInfoViewModel = hiltViewModel()
                val state = viewModel.state.value
                val snackbarHostState = remember{SnackbarHostState()}

                LaunchedEffect(key1 = true) {
                    viewModel.eventFlow.collectLatest { event->
                        when(event){
                            is WordInfoViewModel.UIEvent.ShowSnackbar->{
                                snackbarHostState.showSnackbar(
                                    message = event.message
                                )
                            }
                        }
                    }
                }
                Scaffold(
                    snackbarHost  = { SnackbarHost(snackbarHostState)}
                ) {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            TextField(
                                value = viewModel.searchQuery.value,
                                onValueChange = viewModel::onSearch,
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(text = "Search...")
                                }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            LazyColumn(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                items(state.wordInfoItems.size) { i ->
                                    val wordInfo = state.wordInfoItems[i]
                                    if(i > 0) {
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }
                                    WordInfoItem(wordInfo = wordInfo)
                                    if(i < state.wordInfoItems.size - 1) {
                                        Divider()
                                    }
                                }
                            }
                        }
                        if(state.isLoading) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                    }
                }


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
        }
    }
}

