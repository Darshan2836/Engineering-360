package com.nutan.engineering.CareerCounsellingModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nutan.engineering.HomePage;
import com.nutan.engineering.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EngineeringRightDegreeConculsion extends AppCompatActivity {


    @BindView(R.id.result_id)
    TextView resultTxt;

    @BindView(R.id.homePageBtn_id)
    Button homePageBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering_right_degree_conculsion);

        ButterKnife.bind(this);

        ArrayList<String> result = (ArrayList<String>) getIntent().getSerializableExtra("result");

        for(int i=0;i<result.size();i++)
        {
            if(result.get(i)!= null)
            {
                resultTxt.append(result.get(i));
                resultTxt.append("\n \n \n");
            }
        }


        homePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EngineeringRightDegreeConculsion.this, HomePage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}