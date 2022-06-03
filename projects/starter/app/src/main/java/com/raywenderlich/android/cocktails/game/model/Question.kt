package com.raywenderlich.android.cocktails.game.model

class Question(private val correctOption: String, private val incorrectOption: String) {

    var answerOptions: String? = null
        private set

    val isAnsweredCorrectly: Boolean
        get() = correctOption == answerOptions

    fun answer(option: String): Boolean {

        if (option != correctOption && option != incorrectOption) {
            throw
            IllegalArgumentException("not a valid option")
        }
        // No implementation yet
        answerOptions = option

        return isAnsweredCorrectly
    }


    fun getOptions(sort: (List<String>) -> List<String> = { it.shuffled() }) =
        sort(listOf(correctOption, incorrectOption))
}