package com.nutan.engineering;

import androidx.annotation.BinderThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.nutan.engineering.CareerCounsellingModule.ChooseBranch;
import com.nutan.engineering.CareerCounsellingModule.EngineeringRightDegree;
import com.nutan.engineering.CareerCounsellingModule.PostGrad;
import com.nutan.engineering.CareerCounsellingModule.UnderstandingStreamActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CareerCounselling extends AppCompatActivity {


    @BindView(R.id.customersToolbar_id)
    Toolbar toolbar;

    @BindView(R.id.enginerring_id)
    CardView eng;

    @BindView(R.id.branch_id)
    CardView branch;

    @BindView(R.id.postGrad_id)
    CardView postGrad;

    @BindView(R.id.understandingStream_id)
    CardView understandingStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_counselling);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CareerCounselling.this, EngineeringRightDegree.class));
            }
        });

        branch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CareerCounselling.this, ChooseBranch.class));
            }
        });

        postGrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CareerCounselling.this, PostGrad.class));
            }
        });

        understandingStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CareerCounselling.this, UnderstandingStreamActivity.class));
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