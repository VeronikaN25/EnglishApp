package com.example.magicenglish.grammar_trainer.presentation.nouns_test.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.magicenglish.grammar_trainer.presentation.nouns_test.utils.NounsTestQuestion
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
@Preview(showBackground = true)
@Composable
fun NounsTestScreen() {
    var currentPage by remember { mutableStateOf(0) }
    val totalPages = NounsTestQuestion.testQuestion.size
    val dialogState = remember { mutableStateOf(false) }
    val isCorrectAnswer = remember { mutableStateOf(true) }// Состояние для отслеживания правильности ответа
    val correctAnswer = remember { mutableStateOf("") }// Состояние для хранения правильного ответа

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp),
    ) {
        Text(text = "Page ${currentPage + 1} of $totalPages", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(25.dp))
        if (currentPage < totalPages) {
            val question = NounsTestQuestion.testQuestion[currentPage]
            QuestionPage(question.question, question.options) { answer ->
                // Проверка правильности ответа
                isCorrectAnswer.value = (answer == question.correctAnswer)
                correctAnswer.value = question.correctAnswer
                dialogState.value = true
            }
        } else {
            // Все вопросы пройдены
            Text("Test completed!", fontSize = 35.sp)
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

@Composable
fun QuestionPage(
    question: String,
    options: List<String>,
    onNextClicked: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = question, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(25.dp))
        options.forEach { option ->
            OptionButton(option) { onNextClicked(option) }
        }
    }
}

@Composable
fun OptionButton(option: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            RadioButton(
                selected = false,
                onClick = null
            )
            Text(option, modifier = Modifier.padding(start = 8.dp))
        }
    }
}

