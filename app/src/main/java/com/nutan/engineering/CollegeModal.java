package com.nutan.engineering;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class CollegeModal implements Serializable, Parcelable {

    String collegeName;
    String clgImage1;
    String locality;

    public CollegeModal() {
    }

    public CollegeModal(String collegeName, String clgImage1, String locality) {
        this.collegeName = collegeName;
        this.clgImage1 = clgImage1;
        this.locality = locality;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getclgImage1() {
        return clgImage1;
    }

    public void setclgImage1(String clgImage1) {
        this.clgImage1 = clgImage1;
    }

    public String getlocality() {
        return locality;
    }

    public void setlocality(String locality) {
        this.locality = locality;
    }

    protected CollegeModal(Parcel in) {
    }

    public static final Creator<CollegeModal> CREATOR = new Creator<CollegeModal>() {
        @Override
        public CollegeModal createFromParcel(Parcel in) {
            return new CollegeModal(in);
        }

        @Override
        public CollegeModal[] newArray(int size) {
            return new CollegeModal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
