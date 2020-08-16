package com.example.android.filmsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
    
public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitQuiz(View view) {

        checkRadioBoxQuestion(R.id.question_one, R.id.question_one_option_one);
        checkTextEntryQuestion(R.id.question_two_answer, "207");
        checkCheckBoxQuestionThree();
        checkRadioBoxQuestion(R.id.question_four, R.id.question_four_option_three);

        Toast.makeText(this, "You got " + score + " point!", Toast.LENGTH_LONG).show();
        score = 0;
        return;

    }


    /**
     * This method is checking the radio box type question
     */
    public void checkRadioBoxQuestion(int questionId, int correctAnswerId) {
        RadioGroup radioGroupOne = (RadioGroup) findViewById(questionId);
        int selectedQuestionAnswer = radioGroupOne.getCheckedRadioButtonId();

        int correctAnswerQuestion = findViewById(correctAnswerId).getId();

        if (selectedQuestionAnswer == correctAnswerQuestion) {
            score = score + 1;
        }
    }


    /**
     * This method is checking the text entry type question
     */
    public void checkTextEntryQuestion(int givenAnswerId, String correctQuestion) {
        EditText givenAnswer = (EditText) findViewById(givenAnswerId);
        String selectedQuestionAnswer = givenAnswer.getText().toString();

        if (selectedQuestionAnswer.matches(correctQuestion)) {
            score = score + 1;
        }
    }

    /**
     * This method is checking the check box type question
     */
    public void checkCheckBoxQuestionThree() {
        CheckBox answerOne = (CheckBox) findViewById(R.id.question_three_option_one);
        CheckBox answerTwo = (CheckBox) findViewById(R.id.question_three_option_two);
        CheckBox answerThree = (CheckBox) findViewById(R.id.question_three_option_three);
        CheckBox answerFour = (CheckBox) findViewById(R.id.question_three_option_four);

        if (answerOne.isChecked() && answerFour.isChecked() && !answerTwo.isChecked() && !answerThree.isChecked()) {
            score = score + 1;
        }
    }
}