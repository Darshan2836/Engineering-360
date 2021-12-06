package com.nutan.engineering.CareerCounsellingModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nutan.engineering.HomePage;
import com.nutan.engineering.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseBranchConclusion extends AppCompatActivity {

    @BindView(R.id.csScore_id)
    TextView csScore;

    @BindView(R.id.itScore_id)
    TextView itScore;

    @BindView(R.id.elecScore_id)
    TextView elecScore;

    @BindView(R.id.entcScore_id)
    TextView entcScore;

    @BindView(R.id.civilScore_id)
    TextView civilScore;

    @BindView(R.id.mechScore_id)
    TextView mechScore;

    @BindView(R.id.homePageBtn_id)
    Button homePageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_branch_conclusion);

        ButterKnife.bind(this);


        int it=0,comp =0,elec=0,entc=0,mech=0,civil=0;
        comp = getIntent().getIntExtra("comp",0);
        it = getIntent().getIntExtra("it",0);
        elec = getIntent().getIntExtra("elec",0);
        entc = getIntent().getIntExtra("entc",0);
        mech = getIntent().getIntExtra("mech",0);
        civil = getIntent().getIntExtra("civil",0);

        csScore.setText(String.valueOf(comp));
        itScore.setText(String.valueOf(it));
        elecScore.setText(String.valueOf(elec));
        entcScore.setText(String.valueOf(entc));
        civilScore.setText(String.valueOf(civil));
        mechScore.setText(String.valueOf(mech));


        homePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseBranchConclusion.this, HomePage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}