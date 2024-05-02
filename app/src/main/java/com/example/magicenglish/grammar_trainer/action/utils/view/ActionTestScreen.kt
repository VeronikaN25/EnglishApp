package com.example.magicenglish.grammar_trainer.action.utils.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.magicenglish.grammar_trainer.action.utils.QuestionPage
import com.example.magicenglish.grammar_trainer.action.utils.TestQuestion
import com.example.magicenglish.ui.theme.BrandColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarN(){
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = null,
                    modifier = Modifier.size(55.dp)
                )
            }
        },
        title = {
            LinearProgressIndicator()
        },
    )
}

@Composable
fun ActionTestScreen(testQuestions: List<TestQuestion>,) {
    var currentPage by remember { mutableStateOf(0) }
    val totalPages = testQuestions.size
    val dialogState = remember { mutableStateOf(false) }
    val isCorrectAnswer = remember { mutableStateOf(true) } // Состояние для отслеживания правильности ответа
    val correctAnswer = remember { mutableStateOf("") } // Состояние для хранения правильного ответа
    val testCompleted = remember { mutableStateOf(false) } // Состояние для отслеживания завершения теста

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp),
    ) {
        Text(text = "Page ${currentPage + 1} of $totalPages", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(25.dp))
        if (currentPage < totalPages) {
            val question = testQuestions[currentPage]
            QuestionPage(question.question, question.options) { answer ->
                // Проверка правильности ответа
                isCorrectAnswer.value = (answer == question.correctAnswer)
                correctAnswer.value = question.correctAnswer
                dialogState.value = true
            }
        }else{
            testCompleted.value = true
        }

        if (testCompleted.value) {
            val totalQuestions = testQuestions.size
            val correctAnswers = if (isCorrectAnswer.value) 1 else 0 // Если ответ верный, установим 1, в противном случае 0
            val incorrectAnswers = totalQuestions - correctAnswers
            val score = (correctAnswers.toFloat() / totalQuestions.toFloat()) * 100

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Test completed!",
                    fontSize = 35.sp
                )
                Text(
                    text = "Total Questions: $totalQuestions",
                    fontSize = 20.sp
                )
                Text(
                    text = "Correct Answers: $correctAnswers",
                    fontSize = 20.sp
                )
                Text(
                    text = "Incorrect Answers: $incorrectAnswers",
                    fontSize = 20.sp
                )
                Text(
                    text = "Score: ${"%.2f".format(score)}%",
                    fontSize = 20.sp
                )
            }
        }

        if (dialogState.value){
            val message = if(isCorrectAnswer.value) "Correct answer" else "Incorrect answer!\nThe correct answer is  ${correctAnswer.value}"
            AlertDialog(
                onDismissRequest = {
                    dialogState.value = false
                    if (!isCorrectAnswer.value) {
                        currentPage++
                    }},
                title = { Text(text = message) },
                confirmButton = {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = BrandColor,
                            contentColor = Color.White
                        ),
                        onClick = {
                            dialogState.value = false
                            if (!isCorrectAnswer.value) {
                                currentPage++
                            }else if (isCorrectAnswer.value){
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



