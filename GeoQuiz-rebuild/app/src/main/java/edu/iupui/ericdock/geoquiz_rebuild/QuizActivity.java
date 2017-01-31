package edu.iupui.ericdock.geoquiz_rebuild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.iupui.ericdock.geoquiz_rebuild.R;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class QuizActivity extends AppCompatActivity {

    // TAG FOR LOGGING
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mCheatButton;

    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_capital, false)
    };

    private int mCurrentIndex = 0;

    // pull resource ID from array of questions + show it in the TextView
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userAnswer ) {
        boolean correctAnswer = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userAnswer == correctAnswer) {
            messageResId = R.string.correct_toast;
        }
        else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this,
                messageResId,
                Toast.LENGTH_SHORT)
        .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // LOG CREATION OF ACTIVITY
        Log.d(TAG, "onCreate(Bundle) called");

        // SET CONTENT VIEW TO OUR XML
        setContentView(R.layout.activity_quiz);

        // CHECK FOR BUNDLE, USE PREVIOUS INDEX IF IT EXISTS
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        // TEXTVIEW
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        // BUTTONS
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mPrevButton = (Button) findViewById(R.id.prev_button);
        mCheatButton = (Button) findViewById(R.id.cheat_button);

        // EVENT LISTENERS
        mTrueButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener((new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        }));

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // if we hit the last question, overflow to the beginning
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;

                updateQuestion();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // if we hit the last question, overflow to the beginning
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;

                updateQuestion();
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mCurrentIndex > 0) {
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                }
                else {
                    mCurrentIndex = mQuestionBank.length - 1;
                }

                updateQuestion();
            }
        });

        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start CheatActivity
                Intent i = new Intent(QuizActivity.this, CheatActivity.class);
                startActivity(i);
            }
        });
    }

    // SAVE BUNDLE
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);

    }

    // LOGGING OVERRIDES
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}