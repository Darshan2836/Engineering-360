package com.nutan.engineering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nutan.engineering.adapter.FindBestCollegeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindBestEngClg extends AppCompatActivity {


    @BindView(R.id.bestEnggClgToolbar_id)
    Toolbar toolbar;
    @BindView(R.id.collegesSearchEditText_id)
    AppCompatEditText searchEditText;
    @BindView(R.id.collegesRecyclerView_id)
    RecyclerView recyclerView;
    @BindView(R.id.collegesProgressBar_id)
    ProgressBar newOrdersProgressBar;

    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private String mobileNo;
    private Bundle extras;


    String searchedText;
    ArrayList<CollegeModal> collegeList;

    //adapter
    FindBestCollegeAdapter collegeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_best_eng_clg);


        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //firebase
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        

        searchedText = "";

        //create new list
        collegeList= new ArrayList<>();


        //get Order List
        getCollegeList();


        //search
        searchEditText.addTextChangedListener(search);


    }
    //get all orders list
    private void getCollegeList() {

        db.collection("Colleges").get().addOnCompleteListener(orders -> {
            if (orders.getResult() != null){
                collegeList = (ArrayList<CollegeModal>) orders.getResult().toObjects(CollegeModal.class);

                //set recycler view
                setUpRecyclerView(collegeList,"");
            }
            newOrdersProgressBar.setVisibility(View.INVISIBLE);


        });
    }

    //text watcher for searching
    TextWatcher search = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            if(!s.toString().isEmpty())
            {
                List<CollegeModal> CollegesSearchList = new ArrayList<>();
                searchedText = s.toString().trim();
                for (CollegeModal order: collegeList) {
                    String collegeName = order.getCollegeName();

                    if (collegeName.matches("(?i).*" + searchedText+ ".*")){
                        CollegesSearchList.add(order);
                    }
                }
                setUpRecyclerView(CollegesSearchList,searchedText);
            }
            else
            {
                setUpRecyclerView(collegeList,"");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    private void setUpRecyclerView(List<CollegeModal> paraCollegeList,String searchedText) {


        collegeAdapter = new FindBestCollegeAdapter(paraCollegeList,searchedText);
        recyclerView.setHasFixedSize(false);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(collegeAdapter);

        newOrdersProgressBar.setVisibility(View.INVISIBLE);
        


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}