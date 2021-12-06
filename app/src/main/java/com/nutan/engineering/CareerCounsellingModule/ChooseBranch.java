package com.nutan.engineering.CareerCounsellingModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.nutan.engineering.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseBranch extends AppCompatActivity {

    @BindView(R.id.chooseBranch_id)
    Toolbar toolbar;

    @BindView(R.id.scrollView_id)
    ScrollView scrollview;

    @BindView(R.id.startButton_id)
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_branch);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {Thread.sleep(1000);} catch (InterruptedException e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollview.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        }).start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseBranch.this,ChooseBranchQuiz.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}