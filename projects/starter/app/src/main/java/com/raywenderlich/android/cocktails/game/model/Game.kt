package com.raywenderlich.android.cocktails.game.model

class Game {

    var highScore = 0
    lateinit var list: ArrayList<Question>

    constructor(highScore: Int = 0) {
        this.highScore = highScore
    }

    constructor(list: ArrayList<Question>) {
        this.list = list
    }


    var currentScore = 0
        private set


    private var index = 0


    fun incrementScore() {
        currentScore++
//        highScore++
        setHighScore()
    }

    private fun setHighScore() {
        if (currentScore >= highScore) {
            highScore = currentScore
        }
    }

    fun nextQuestion(): Question? {
        val question: Question?
        if (index < list.size) {
            question = list[index]
            index++
        } else {
            question = null
        }
        return question

    }

}