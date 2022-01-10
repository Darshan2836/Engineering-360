package com.nutan.engineering.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nutan.engineering.R;
import com.smarteist.autoimageslider.SliderViewAdapter;


public class CollegeImageSliderAdapter extends SliderViewAdapter<CollegeImageSliderAdapter.ProductSliderViewHolder> {

    private Context context;
    private int mCount;
    private String productId;

    //firebase
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    public CollegeImageSliderAdapter(Context context,String productId) {
        this.context = context;
        this.productId = productId;
    }

    public void setCount(int count){
        this.mCount = count;
    }

    @Override
    public ProductSliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item,null);
        context = parent.getContext();
        db = FirebaseFirestore.getInstance();
        return new ProductSliderViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ProductSliderViewHolder viewHolder, int position) {

        db.collection("Colleges").document(productId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                int counter = position+1;
                Log.d("POSITION", "onSuccess: "+ counter);

                String image = documentSnapshot.get("clgImage" + counter).toString();
                Glide.with(viewHolder.itemView.getRootView())
                        .load(image)
                        .fitCenter()
                        .into(viewHolder.productImage);


            }
        });
    }

    @Override
    public int getCount() {
        return mCount;
    }

    class ProductSliderViewHolder extends SliderViewAdapter.ViewHolder{

        View itemView;
        AppCompatImageView productImage;

        public ProductSliderViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            productImage = itemView.findViewById(R.id.imageSliderItemImage_id);
        }
    }

}