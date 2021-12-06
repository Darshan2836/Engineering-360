package com.nutan.engineering.CareerCounsellingModule;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.nutan.engineering.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UnderstandingStreamActivity extends AppCompatActivity {


    @BindView(R.id.ComputerEngineeringId)
    CardView comp;

    @BindView(R.id.ITEngineeringId)
    CardView it;

    @BindView(R.id.ElectricalEngineeringId)
    CardView electrical;

    @BindView(R.id.EntcId)
    CardView entc;

    @BindView(R.id.CivilEnggId)
    CardView civil;

    @BindView(R.id.mechId)
    CardView mech;

    //WebView CompWebView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_understanding_stream);


        ButterKnife.bind(this);

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=avZTQgLs064")));

            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=zKEwYgLW9TU")));

            }
        });

        electrical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=QQewdCJTcIU")));

            }
        });

        entc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=o3nmCfgqCz4")));

            }
        });
        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=bFljMHTQ1QY")));

            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=W74y1RxN6BA")));

            }
        });

    }
}