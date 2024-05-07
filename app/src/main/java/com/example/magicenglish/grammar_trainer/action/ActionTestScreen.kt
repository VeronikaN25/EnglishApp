package com.example.magicenglish.grammar_trainer.action

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.substring
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.magicenglish.ui.theme.BrandColor

class ActionTestScreenActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActionTestScreen(testQuestions = nounsTestQuestion)
        }
    }
}
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
                Text("Do you really want to get out?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        dialogState.value = false
                        navController.navigateUp()
                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(onClick = {
                    dialogState.value=false
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

            // Отображаем результаты теста по середине экрана
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Test completed!\nScore: ${score.toInt()}%\nCorrect answer: $correctAnswersCount\nIncorrect answer: $incorrectAnswers",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {

                    }
                ) {
                    Text("Вернуться к списку")
                }
            }
        } else {
            TopAppBar(navController = navController)
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
            val message =
                if (isCorrectAnswer.value) "Correct answer" else "Incorrect answer!\nThe correct answer is  ${correctAnswer.value}"
            val correctAnswerText = "Correct answer is"
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
                            containerColor = Color.Gray,
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


