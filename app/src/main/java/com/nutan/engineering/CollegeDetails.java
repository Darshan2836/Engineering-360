package com.nutan.engineering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nutan.engineering.adapter.CollegeImageSliderAdapter;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollegeDetails extends AppCompatActivity {


    @BindView(R.id.productPageProgressBar_id)
    ProgressBar productPageProgressBar;

    @BindView(R.id.productPageToolbar_id)
    Toolbar toolbar;

    @BindView(R.id.productPageImageSlider_id)
    SliderView sliderView;

    @BindView(R.id.collegeName_id)
    AppCompatTextView collegeName;

    @BindView(R.id.collegeAddress_id)
    AppCompatTextView collegeAddress;

    @BindView(R.id.collegeCET_id)
    AppCompatTextView collegeCET;

    @BindView(R.id.collegeLocality_id)
    AppCompatTextView collegeLocality;

    @BindView(R.id.collegePlacement_id)
    AppCompatTextView collegePlacement;

    @BindView(R.id.collegeFees_id)
    AppCompatTextView collegeFees;

    @BindView(R.id.collegeBranches_id)
    AppCompatTextView collegeBranches;

    @BindView(R.id.collegeDetails_id)
    AppCompatTextView collegeDetails;

    private CollegeImageSliderAdapter collegeSliderAdapter;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private int collegeImageNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_details);

        ButterKnife.bind(this);

        db = FirebaseFirestore.getInstance();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String collegeNameTxt = getIntent().getStringExtra("CollegeName");

        collegeSliderAdapter = new CollegeImageSliderAdapter( this,collegeNameTxt);

        //getting product images
        db.collection("Colleges").document(collegeNameTxt).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    collegeImageNo = Integer.parseInt(task.getResult().get("clgImageNo").toString());


                    collegeSliderAdapter.setCount(collegeImageNo);


                    sliderView.setSliderAdapter(collegeSliderAdapter);
                    sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE);
                    //sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
                    sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                    sliderView.setIndicatorSelectedColor(Color.BLACK);
                    sliderView.setIndicatorUnselectedColor(Color.GRAY);
                    sliderView.setScrollTimeInSec(3); //set scroll delay in seconds :
                    sliderView.startAutoCycle();

                    collegeName.setText(collegeNameTxt);
                    collegeAddress.setText(task.getResult().get("Address").toString());
                    collegeCET.setText(task.getResult().get("CetScore").toString());
                    collegeLocality.setText(task.getResult().get("locality").toString());
                    collegeFees.setText(task.getResult().get("Fees").toString());
                    collegePlacement.setText(task.getResult().get("PlacementPercentage").toString() + "%");
                    collegeDetails.setText(task.getResult().get("CollegeDescription").toString());

                    ArrayList<String> branches = (ArrayList<String>) task.getResult().get("Branches");

                    int i=0;
                    for(i=0;i<branches.size();i++)
                    {
                        collegeBranches.append("\u2022 " + branches.get(i) + "\n");
                    }

                    productPageProgressBar.setVisibility(View.INVISIBLE);
                }
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