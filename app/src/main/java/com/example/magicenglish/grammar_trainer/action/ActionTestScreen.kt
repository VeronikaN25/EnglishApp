package com.example.magicenglish.grammar_trainer.action

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.magicenglish.ui.theme.DarkBlue
import com.example.magicenglish.ui.theme.DarkRed
import com.example.magicenglish.ui.theme.DeepSkyBlue
import com.example.magicenglish.ui.theme.LawnGreen
import com.example.magicenglish.ui.theme.Orange


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavController){
    val dialogState = remember { mutableStateOf(false) }
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                dialogState.value = true
            }) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = null,
                    modifier = Modifier.size(55.dp)
                )
            } },
        title = {},
        )
    if (dialogState.value) {
        AlertDialog(
            onDismissRequest = { dialogState.value = false },
            title = {},
            text = {
                Text("Do you really want to get out?", fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
            },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(LawnGreen),
                    onClick = {

                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(DarkRed),
                    onClick = {

                }) {
                    Text(text = "No")
                }
            }
        )
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun ActionTestScreen(testQuestions: List<TestQuestion>) {
    val navController = rememberNavController()

    val context = LocalContext.current
    val isNetworkAvailable = remember { isNetworkAvailable(context) }

    var currentPage by remember { mutableStateOf(0) }
    val totalPages = testQuestions.size
    val dialogState = remember { mutableStateOf(false) }
    val isCorrectAnswer = remember { mutableStateOf(true) } // Состояние для отслеживания правильности ответа
    val correctAnswer = remember { mutableStateOf("") } // Состояние для хранения правильного ответа
    val testCompleted = remember { mutableStateOf(false) } // Состояние для отслеживания завершения теста
    var correctAnswersCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
    ) {
        if (testCompleted.value) {
            val totalQuestions = testQuestions.size
            val incorrectAnswers = totalQuestions - correctAnswersCount
            val score = (correctAnswersCount.toFloat() / totalQuestions.toFloat()) * 100
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    DarkBlue,
                                    fontSize = 35.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("Test completed!  ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    DeepSkyBlue,
                                    fontSize = 35.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("  ${score.toInt()}%\n")
                            }
                            append("Correct answers: ")
                            withStyle(style = SpanStyle(color = LawnGreen, fontSize = 25.sp)) {
                                append("$correctAnswersCount\n")
                            }
                            append("Incorrect answers: ")
                            withStyle(style = SpanStyle(color = DarkRed, fontSize = 25.sp)) {
                                append("$incorrectAnswers")
                            }
                        },
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        lineHeight = 60.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Orange,
                                contentColor = Color.White
                            ),
                            modifier = Modifier.height(56.dp),
                            onClick = {

                            }
                        ) {
                            Text("Back to list", fontSize = 20.sp)
                        }
                    }
                }
            }
        } else if(!isNetworkAvailable){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "No network connection.\nPlease check your internet connection and try again.",
                        color = Color.Red,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /* Retry logic or other handling */ }
                    ) {
                        Text("Retry")
                    }
                }
            }
        }
        else {
            Row {
                TopAppBar(navController = navController)
            }
            Text(
                text = "Page ${currentPage + 1} of $totalPages",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(25.dp))
            if (currentPage < totalPages) {
                val question = testQuestions[currentPage]
                QuestionPage(question.question, question.options) { answer ->
                    // Проверка правильности ответа
                    if (answer == question.correctAnswer) {
                        correctAnswersCount++
                        isCorrectAnswer.value = true
                    } else {
                        isCorrectAnswer.value = false
                    }
                    correctAnswer.value = question.correctAnswer
                    dialogState.value = true
                }
            } else {
                testCompleted.value = true
            }
        }
        if (dialogState.value) {
            val message = if (isCorrectAnswer.value) {
                buildAnnotatedString {
                    withStyle(style = SpanStyle(LawnGreen, fontWeight = FontWeight.Bold)) {
                        append("Correct answer !")
                    }
                }
            } else {
                buildAnnotatedString {
                    withStyle(style = SpanStyle(DarkRed, fontWeight = FontWeight.Bold),) {
                        append("Incorrect answer ! \n")
                    }
                    append("The correct answer is \n")
                    withStyle(style = SpanStyle(LawnGreen, fontWeight = FontWeight.Bold)) {
                        append(correctAnswer.value)
                    }
                }
            }
            AlertDialog(
                onDismissRequest = {
                    dialogState.value = false
                    if (!isCorrectAnswer.value) {
                        currentPage++
                    }
                },
                title = {
                    Text(text = message)
                },
                confirmButton = {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = DarkBlue,
                            contentColor = Color.White
                        ),
                        onClick = {
                            dialogState.value = false
                            if (!isCorrectAnswer.value) {
                                currentPage++
                            } else if (isCorrectAnswer.value) {
                                currentPage++
                            }
                        }) {
                        Text(text = "Next")
                    }
                }
            )
        }
    }
}

fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
    return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}
