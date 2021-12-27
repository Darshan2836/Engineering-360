package com.nutan.engineering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nutan.engineering.addCollege.AddCollegeQuiz;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddCollege extends AppCompatActivity {

    @BindView(R.id.procced_btn_id)
    Button proceed_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_college);
        ButterKnife.bind(this);

        proceed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddCollege.this, AddCollegeQuiz.class));
            }
        });

    }
}