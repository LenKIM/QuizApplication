package com.android.len.myquizapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private val mQuestionBank = arrayOf(
    Question(R.string.question_oceans, true),
    Question(R.string.question_africa, false),
    Question(R.string.question_mideast, false),
    Question(R.string.question_americas, true),
    Question(R.string.question_asia, true)
  )

  private var mCurrentIndex = 1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.d(TAG, "onCreate(Bundle) called")
    setContentView(R.layout.activity_main)

    if (savedInstanceState != null) {
      mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0)
    }

    question_text.setOnClickListener {
      mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
      updateQuestion()
    }
    updateQuestion()

    true_button.setOnClickListener {
      checkAnswer(true)
    }

    false_button.setOnClickListener {
      checkAnswer(false)
    }

    next_button.setOnClickListener {
      mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
      updateQuestion()
    }

    previous_button.setOnClickListener {
      if (mCurrentIndex == 0) {
        noAnyQuestion()
      } else {
        mCurrentIndex = (mCurrentIndex - 1) % question_text.length()
        updateQuestion()
      }
    }
  }

  override fun onStart() {
    super.onStart()
    Log.d(TAG, "onStart() called")
  }

  override fun onPause() {
    super.onPause()
    Log.d(TAG, "onPause() called")
  }

  override fun onResume() {
    super.onResume()
    Log.d(TAG, "onResume() called")
  }

  override fun onStop() {
    super.onStop()
    Log.d(TAG, "onStop() called")
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.d(TAG, "onDestroy() called")
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    Log.i(TAG, "onSaveInstanceState")
    outState.putInt(KEY_INDEX, mCurrentIndex)
  }

  private fun noAnyQuestion() {
    Toast.makeText(this@MainActivity, R.string.no_more_question, Toast.LENGTH_SHORT).show()
  }

  private fun checkAnswer(userPressedTrue: Boolean) {

    val answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue

    var messageResId = 0
    messageResId = if (userPressedTrue == answerIsTrue) {
      R.string.correct_toast
    } else {
      R.string.incorrect_toast
    }
    Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
  }

  private fun updateQuestion() {
    val question = mQuestionBank[mCurrentIndex].textResId
    question_text.setText(question)
  }

  companion object {
    private val KEY_INDEX = "index"
    private val TAG = "QuizActivity"
  }
}
