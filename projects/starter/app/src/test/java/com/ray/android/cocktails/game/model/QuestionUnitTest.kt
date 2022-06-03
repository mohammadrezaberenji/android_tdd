package com.ray.android.cocktails.game.model

import com.raywenderlich.android.cocktails.game.model.Question
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class QuestionUnitTest {

    private lateinit var question: Question

    @Before
    fun setup() {
        question = Question("CORRECT", "INCORRECT")
    }


    @Test
    fun whenCreatingQuestionShouldNotHaveAnswerOptions() {
        Assert.assertNull(question.answerOptions)

    }

    @Test
    fun whenAnsweringShouldHaveAnswerOptions() {
        val result = question.answer("INCORRECT")

        Assert.assertFalse(result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenAnsweringWithInvalidOptionReturnIllegalArgumentException() {

        question.answer("INVALID")
    }

    @Test
    fun checkGetOptions() {
        val options = question.getOptions { it.reversed() }
        Assert.assertEquals(listOf("INCORRECT", "CORRECT"), options)
    }


}