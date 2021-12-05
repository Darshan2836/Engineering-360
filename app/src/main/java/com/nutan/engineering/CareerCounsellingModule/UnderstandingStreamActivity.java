package com.nutan.engineering.CareerCounsellingModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.nutan.engineering.R;
import com.nutan.engineering.webViews.compWebViewAct;

import butterknife.BindView;

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

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=avZTQgLs064")));
            //Intent intent = new Intent(UnderstandingStreamActivity.this,compWebViewAct.class);
            //startActivity(intent);
            }
        });

    }
}