package com.example.magicenglish.grammar_trainer.action.utils

data class TestQuestion(
    val question: String,
    val options:List<String>,
    val correctAnswer:String
)
val nounsTestQuestion = listOf(
    TestQuestion("My mother is allergic to ..... cigarette smoke", listOf("the", "----","a"),"----"),
    TestQuestion("The books _ on the table in the living room", listOf("is","are","am"),"are"),
    TestQuestion("The _ rooms are upstairs", listOf("childrens'","children","childs","children's"),"children's"),
    TestQuestion("How many _ have you visited?", listOf("country'","countrys","countries","country's"),"countries"),
    TestQuestion("I don't have _ money for lunch", listOf("some'","few","any","little"),"any"),
    TestQuestion("I have _ friends in America", listOf("little'","few","a little","a few"),"a few"),
    TestQuestion("There are _ students", listOf("a lot of'","much","any"),"a lot of"),
    TestQuestion("There is _ ice cream", listOf("many'","a lot of","much"),"a lot of"),
    TestQuestion("_ there any tomatoes in the salad?", listOf("IS'","Are","Am"),"Are"),
    TestQuestion("We like _ jelly on our toast", listOf("a little'","a few","many"),"a little"),
)