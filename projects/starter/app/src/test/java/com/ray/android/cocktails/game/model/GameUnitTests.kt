package com.ray.android.cocktails.game.model

import com.raywenderlich.android.cocktails.game.model.Game
import com.raywenderlich.android.cocktails.game.model.Question
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameUnitTests {


    private lateinit var game: Game


    @Before
    fun makeGameObj() {
        game = Game()
    }


    @Test
    fun whenIncrementScore() {

        game.incrementScore()
// 4
        Assert.assertEquals(1, game.currentScore)
    }


    @Test
    fun whenIncrementingScoreMustAlsoIncrementHighScoreToo() {

        game.incrementScore()

        Assert.assertEquals(1, game.highScore)
    }

    @Test
    fun whenIncrementingScoreIsBelowHighScoreShouldNotChangeIt() {
        val game = Game(10)

        game.incrementScore()

        Assert.assertEquals(10, game.highScore)
    }

    @Test
    fun getNextQuestionIfItHas() {
        val question = Question("HI" , "BYE")
        val list = arrayListOf(question)
        val game = Game(list)
        Assert.assertSame(game.nextQuestion() , question)
    }

    @Test
    fun getNullIfItIsEndOfList(){
        val question = Question("HI" , "BYE")
        val game = Game(arrayListOf(question))
        game.nextQuestion()
        Assert.assertNull(game.nextQuestion())
    }
}