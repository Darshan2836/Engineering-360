package com.nutan.engineering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.jai.genericdialog2.GenericDialog;
import dev.jai.genericdialog2.GenericDialogOnClickListener;

public class HomePage extends AppCompatActivity {


    //side navigation
    Drawer drawer = null;
    AccountHeader accountHeader = null;
    private DisplayMetrics displayMetrics;
    private int widthScreen;
    private int heightScreen;

    private Context context;
    private static final int WRITE_PERMISSION = 99;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private String userMobileNo;

    //widgets
    @BindView(R.id.mainToolbar_id)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitleTextAppearance(this, R.style.MainMyToolbarStyle);


        //mAuth
        mAuth =FirebaseAuth.getInstance();

        //db connection
        db = FirebaseFirestore.getInstance();


        userMobileNo = mAuth.getCurrentUser().getPhoneNumber();
        context = getApplicationContext();
        displayMetrics = new DisplayMetrics();
        displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;

        widthScreen = (int) Math.abs(dpWidth * 0.7);
        heightScreen = (int) Math.abs(dpHeight * 0.3);


        buildDrawer();
       


    }


    private void buildDrawer() {



        PrimaryDrawerItem orders = new PrimaryDrawerItem().withName("Career Counselling").withSelectable(false);
        PrimaryDrawerItem returnedOrders = new PrimaryDrawerItem().withName("Find best engineering college for you").withSelectable(false);
        PrimaryDrawerItem products = new PrimaryDrawerItem().withName("Plan your Engineering studies").withSelectable(false);
        PrimaryDrawerItem logout = new PrimaryDrawerItem().withName("Logout").withSelectable(false);

        ProfileDrawerItem profileDrawerItem = new ProfileDrawerItem().withEmail(userMobileNo).withIcon(R.drawable.ic_baseline_account_circle_24);

        accountHeader = new AccountHeaderBuilder()
                .addProfiles(profileDrawerItem)
                .withActivity(this)
                .withHeaderBackground(R.color.colorPrimaryDark)
                .withTextColor(getResources().getColor(R.color.md_white_1000))
                .withHeightDp(180)
                .withSelectionListEnabled(false)
                .withProfileImagesClickable(false)
                .build();

        drawer = new DrawerBuilder()
                .withAccountHeader(accountHeader)
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(orders,returnedOrders,products,logout)
                .withDisplayBelowStatusBar(true)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggleAnimated(false)
                .withDrawerWidthDp(widthScreen)
                .withSelectedItem(-1)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position){
                            case 1:
                                //orders
                                Intent ordersIntent = new Intent(HomePage.this, CareerCounselling.class);
                                startActivity(ordersIntent);
                                drawer.closeDrawer();
                                return true;
                            case 2:
                                //returnedOrders
                                Intent returnedOrders = new Intent(HomePage.this,FindBestEngClg.class);
                                startActivity(returnedOrders);
                                drawer.closeDrawer();
                                return true;
                            case 3:
                                //products
                                Intent products = new Intent(HomePage.this,PlanYourStudies.class);
                                startActivity(products);
                                drawer.closeDrawer();
                                return true;

                            case 12:
                                //logout
                                new GenericDialog.Builder(HomePage.this)
                                        .setCancelable(false)
                                        .setMessage("Are you sure you want to logout?")
                                        .setTitle("Please confirm")
                                        .setDialogTheme(R.style.GenericDialogTheme)
                                        .addNewButton(R.style.OkBtn, new GenericDialogOnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                //proceed
                                                mAuth.signOut();
                                                sendToLogin();
                                            }
                                        })
                                        .addNewButton(R.style.NoBtn, new GenericDialogOnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                //cancel
                                            }
                                        })
                                        .generate();
                                return true;
                        }
                        return false;
                    }
                })
                .build();

    }


    private void sendToLogin() {
        Intent loginIntent = new Intent(HomePage.this,MainActivity.class);
        startActivity(loginIntent);
        finish();
    }
}