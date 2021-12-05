package com.nutan.engineering.CareerCounsellingModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nutan.engineering.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EngineeringRightDegreeQuiz extends AppCompatActivity {


    @BindView(R.id.questionCounter_id)
    TextView questionCounter;

    @BindView(R.id.question_id)
    TextView question;

    @BindView(R.id.yesButton_id)
    Button yesButton;

    @BindView(R.id.noButton_id)
    Button noButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering_right_degree_quiz);

        ButterKnife.bind(this);

        int arr[] = new int[5];
        ArrayList<String> questions = new ArrayList<>();


        int count=0;

        while (count<5)
        {


            int finalCount = count;
            yesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    arr[finalCount] = 1;
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    arr[finalCount] = 0;
                }
            });



            count++;
        }

    }
}