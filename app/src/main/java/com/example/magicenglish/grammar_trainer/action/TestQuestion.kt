package com.example.magicenglish.grammar_trainer.action

data class TestQuestion(
    val question: String,
    val options:List<String>,
    val correctAnswer:String
)
val nounsTestQuestion = listOf(
    TestQuestion("My mother is allergic to .... cigarette smoke", listOf("the", "----","a"),"----"),
    TestQuestion("The books .... on the table in the living room", listOf("is","are","am"),"are"),
    TestQuestion("The .... rooms are upstairs", listOf("childrens","children","childs","children's"),"children's"),
    TestQuestion("How many .... have you visited?", listOf("country'","countrys","countries","country's"),"countries"),
    TestQuestion("I don't have .... money for lunch", listOf("some'","few","any","little"),"any"),
    TestQuestion("I have .... friends in America", listOf("little'","few","a little","a few"),"a few"),
    TestQuestion("There are .... students", listOf("a lot of'","much","any"),"a lot of"),
    TestQuestion("There is .... ice cream", listOf("many'","a lot of","much"),"a lot of"),
    TestQuestion(".... there any tomatoes in the salad?", listOf("IS'","Are","Am"),"Are"),
    TestQuestion("We like .... jelly on our toast", listOf("a little'","a few","many"),"a little"),
)
val pronounsTestQuestion= listOf(
    TestQuestion("He doesn't trust ....", listOf("I","me","mine","he"),"me"),
    TestQuestion("Are these beautiful paintings .... ?", listOf("you","your","yours","yourself"),"yours"),
    TestQuestion("I have a cat. This cat is ....", listOf("his","her","mine"),"mine"),
    TestQuestion("The house is theirs and its paint is flaking.'Theirs' is .... ", listOf("Possessive","Personal"),"Possessive"),
    TestQuestion("I can't find my mobile phone ....", listOf("nowhere","somewhere","anywhere"),"anywhere"),
    TestQuestion("The glass is empty. .... drank my orange juice", listOf("No one"," Anyone","Someone"),"Someone"),
    TestQuestion("Do you know .... who has got blue hair?", listOf("somebody","someone","anybody","something"),"anybody"),
    TestQuestion("The music is too loud. I can't hear ....", listOf("something","nothing","anything"),"nothing"),
    TestQuestion("Linkin Park was a very popular band. .... knows it.", listOf("Everyone","They","Someone"),"Everyone"),
)

val presentTensesTestQuestion= listOf(
    TestQuestion("Mr.Ban eats meat, but his wife ....", listOf("didn't","don't","doesn't"),"doesn't"),
    TestQuestion(".... we been there before?", listOf("Has","Have"),"Have"),
    TestQuestion("Let's choose a big company, .... , Ford and examine their pricing policy.", listOf("say","telling","tell","saying"),"say"),
    TestQuestion("Do as I .... , not as I do.", listOf("told","say","said","tell"),"say"),
    TestQuestion("The earth .... round the sun , doesn't it?", listOf("goes","go","went"),"goes"),
    TestQuestion("Tom .... like chocolate ice cream.", listOf("don't","doesn't","didn't"),"doesn't"),
    TestQuestion("Does Jim often .... here?", listOf("swims","swim","swimming"),"swim"),
    TestQuestion("What time do you .... up?", listOf("got","get","gets"),"get"),
    TestQuestion("Does your girlfriend .... coffee for you?", listOf("make","made","making"),"make"),
    TestQuestion("I .... studied Chinese for five years.", listOf("having","have","has"),"have"),
)
val pastTensesTestQuestion= listOf(
    TestQuestion("The dog was .... after the cat.", listOf("ran","has run","running"),"running"),
    TestQuestion("What .... you doing last night?", listOf("were","is","was"),"were"),
    TestQuestion("I played tennis .... two hours.", listOf("since","for","with"),"for"),
    TestQuestion("In 1871, British Columbia .... Canadian Confederation. ", listOf("joins","had joined","joined"),"joined"),
    TestQuestion("Sara .... for two hours before she arrived.", listOf("was driving","has driving","had been driving"),"had been driving"),
    TestQuestion("My father .... not go to work yesterday.", listOf("did","do","done"),"did"),
    TestQuestion("Lisa and I .... sick yesterday.", listOf("am","are","were"),"were"),
    TestQuestion("I was very late. When I arrived, the conference .....", listOf("was already starting","started","had already started"),". had already started"),
    TestQuestion("When they arrived at the police station, he said that he .... anything wrong.", listOf("didn't do","wasn't doing","hadn't done"),"hadn't done"),
    TestQuestion("When he said that he loved me, I knew that he ....", listOf("lied"," was lying"," had lied"),""),
)
val futureTensesTestQuestion= listOf(
    TestQuestion("I .... tennis with my friends next Friday.", listOf("will play","m playing","'m going to play"),"m playing"),
    TestQuestion("A: 'Why did you buy a guitar if you can't play?'\nB. 'No, but I ....'", listOf("will learn","'m learning"," 'm going to learn")," 'm going to learn"),
    TestQuestion("We'll find a hotel .... we arrive in Jakarta", listOf("when","while","until"),"when"),
    TestQuestion("I'm very happy! We .... married next week", listOf("getting","going to get","are getting"),"are getting"),
    TestQuestion("A: I don't think he .... come tonight.\nB: But he says he .... come.", listOf("will / will"," is going to / will"," will / is going to")," will / is going to"),
    TestQuestion("A: Don't make so much noise. You .... dad.\nB: OK. I .... now.", listOf("will wake up / will stop","will wake up / 'm going to stop"," are going to wake up / will stop")," are going to wake up / will stop"),
    TestQuestion("When we arrive in Los Angeles we'll need to rest, because we .... about 800 miles.", listOf("will be driving","will have driven","will drive"),"will have driven"),
    TestQuestion("When you get off the train, we .... for you on the platform.", listOf("'ll wait","'ll be waiting",". 'll have waited"),"'ll be waiting"),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
)
//val determinersTensesTestQuestion= listOf(
//    TestQuestion("Mount Everest is in .... Himalayas", listOf("the","a","is"),"the"),
//    TestQuestion("", listOf(""),""),
//    TestQuestion("", listOf(""),""),
//    TestQuestion("", listOf(""),""),
//    TestQuestion("", listOf(""),""),
//    TestQuestion("", listOf(""),""),
//    TestQuestion("", listOf(""),""),
//    TestQuestion("", listOf(""),""),
//    TestQuestion("", listOf(""),""),
//    TestQuestion("", listOf(""),""),
//)
val adjectivesTensesTestQuestion= listOf(
    TestQuestion("People sat that the new law isn't .....", listOf("tough enough","enough tough",),"tough enough"),
    TestQuestion("He broke Mother's .... milk jug", listOf("green old","old green"),"old green"),
    TestQuestion("Mary is a .... swimmer", listOf("slow","slows","slowly"),"slowly"),
    TestQuestion("I was .... because it was such a .... film ", listOf("scaring/frightened","scared/frightening","scaring/frightening"),"scared/frightening"),
    TestQuestion("The teacher told us to be ....", listOf("quietly","quiet"),"quiet"),
    TestQuestion("This story is .... than the other one.", listOf("more interesting","interested","interesting"),"more interesting"),
    TestQuestion("You could give the money to .... children", listOf("them","their","him"),"their"),
    TestQuestion("I'm not good at maths. I count ....", listOf("slowly","slowlly","slow"),"slowly"),
    TestQuestion("He is a .... soccer player", listOf("----","well","good"),"good"),
    TestQuestion("He speaks so .... that i can't understand him", listOf("fast","fastly","faster"),"fast"),
)
val adjectivesComparisonsTensesTestQuestion= listOf(
    TestQuestion("The kitten is as  .... as a puppy", listOf("cute","cuter than","cutest"),"cute"),
    TestQuestion("Choose the correct sentence.", listOf("I feel as fly than bird","I fell as free as a bird","I fell is free is bird"),"I fell as free as a bird"),
    TestQuestion("he is .... tall .... me", listOf("as....than","so....as","as....as"),"as....as"),
    TestQuestion("My father is .... my mother", listOf("busier than ","the busier","more busier than "),"busier than"),
    TestQuestion("Antarctica is .... place on earth ", listOf("more colder","the coldest","the colder"),"the coldest"),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
)
val adverbsTensesTestQuestion= listOf(
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
)
val quantifiersTensesTestQuestion= listOf(
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
)
val questionTagsTensesTestQuestion= listOf(
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
)
val gerundPresentParticipleTensesTestQuestion= listOf(
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
    TestQuestion("", listOf(""),""),
)
