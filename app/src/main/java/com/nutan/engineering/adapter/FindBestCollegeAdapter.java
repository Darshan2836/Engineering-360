package com.nutan.engineering.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nutan.engineering.CollegeDetails;
import com.nutan.engineering.CollegeModal;
import com.nutan.engineering.R;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindBestCollegeAdapter extends RecyclerView.Adapter<FindBestCollegeAdapter.FindBestCollegeVH> {

    private static final String TAG = "DeliveredAdapter";
    private List<CollegeModal> collegeList;
    private Context context;
    private String searchedText;

    public FindBestCollegeAdapter(List<CollegeModal> collegeList,String searchedText){
        this.collegeList = collegeList;
        this.searchedText = searchedText;
    }

    @NonNull
    @Override
    public FindBestCollegeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_cardview, parent, false);
        context = parent.getContext();

        return new FindBestCollegeVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FindBestCollegeVH holder, int position) {


        //get order data
        String collegeName = collegeList.get(position).getCollegeName();
        String collegelocality = collegeList.get(position).getlocality();
        String ImageUrl = collegeList.get(position).getclgImage1();

        //highlight searched text
        if (!searchedText.isEmpty()) {
            Spannable spanText = Spannable.Factory.getInstance().newSpannable(collegeName);

            Matcher matcher = Pattern.compile(Pattern.quote(searchedText), Pattern.CASE_INSENSITIVE).matcher(collegeName);
            while (matcher.find()) {
                spanText.setSpan(new ForegroundColorSpan(Color.RED), matcher.start(),
                        matcher.start() + searchedText.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            holder.collegeName.setText(spanText);
        }
        else
        {
            holder.collegeName.setText(collegeName);
        }



        //set txt
        holder.collegelocality.setText(collegelocality);


        //object
        CollegeModal model = collegeList.get(position);

        //on explore button click
        holder.collegeCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked");
                sendToCollegeDetails(model);
            }
        });

        Glide.with(holder.itemView.getRootView())
                .load(ImageUrl)
                .fitCenter()
                .into(holder.Image);
    }

    private void sendToCollegeDetails(CollegeModal orderDetails) {
        Intent orderExploreIntent = new Intent(context, CollegeDetails.class);
        orderExploreIntent.putExtra("orderDetails", (Serializable) orderDetails);
        context.startActivity(orderExploreIntent);
//        ((Activity)context).finish();
    }

    @Override
    public int getItemCount() {
        return collegeList.size();
    }

    public static class FindBestCollegeVH extends RecyclerView.ViewHolder{
        @BindView(R.id.collegeName_id)
        AppCompatTextView collegeName;
        @BindView(R.id.collegelocality_id)
        AppCompatTextView collegelocality;
        @BindView(R.id.collegeImage_id)
        AppCompatImageView Image;
        @BindView(R.id.collegeCardview_id)
        CardView collegeCardview;

        View itemView;

        public FindBestCollegeVH(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;
            ButterKnife.bind(this,itemView);

        }
    }
}