package com.nutan.engineering.CareerCounsellingModule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.nutan.engineering.R;

import butterknife.BindView;

public class ChooseBranchQuiz extends AppCompatActivity {

    @BindView(R.id.questionCounter_id)
    TextView questionCounter;

    @BindView(R.id.question_id)
    TextView question;

    @BindView(R.id.yesButton_id)
    Button yesButton;

    @BindView(R.id.noButton_id)
    Button noButton;
//
//    @BindView(R.id.yesButton_id)
//    Button yesButton;
//
//    @BindView(R.id.noButton_id)
//    Button noButton;
//
//    @BindView(R.id.noButton_id)
//    Button noButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_branch_quiz);
    }
}