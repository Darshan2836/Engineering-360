package com.nutan.engineering.addCollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nutan.engineering.CareerCounsellingModule.ChooseBranchConclusion;
import com.nutan.engineering.HomePage;
import com.nutan.engineering.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddCollegeConclusion extends AppCompatActivity {


    @BindView(R.id.homePageBtn_id)
    Button homePageBtn;

    @BindView(R.id.clg_avgID)
    TextView clg_avg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_college_conclusion);

        ButterKnife.bind(this);

        int score = getIntent().getIntExtra("score",0);

        if(score>40)
        {
            clg_avg.setText("Above Average");
            clg_avg.setTextColor(getResources().getColor(R.color.green));
        }
        else if(score>20)
        {
            clg_avg.setText("Average");
            clg_avg.setTextColor(getResources().getColor(R.color.black));
        }
        else
        {
            clg_avg.setText("Below Average");
            clg_avg.setTextColor(getResources().getColor(R.color.md_red_900));
        }

        homePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddCollegeConclusion.this, HomePage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}