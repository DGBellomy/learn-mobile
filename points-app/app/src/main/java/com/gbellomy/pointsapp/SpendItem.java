package com.gbellomy.pointsapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gbellomy on 10/1/17.
 */

public class SpendItem implements Parcelable {
    private String mTitle;
    private int mCost;

    public SpendItem(String title, int cost) {
        mTitle = title;
        mCost = cost;
    }

    protected SpendItem(Parcel in) {
        mTitle = in.readString();
        mCost = in.readInt();
    }

    public static final Creator<SpendItem> CREATOR = new Creator<SpendItem>() {
        @Override
        public SpendItem createFromParcel(Parcel in) {
            return new SpendItem(in);
        }

        @Override
        public SpendItem[] newArray(int size) {
            return new SpendItem[size];
        }
    };

    public void setTitle(String newTitle) {
        mTitle = newTitle;
    }

    public void setCost(int newCost) {
        mCost = newCost;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getCost() {
        return mCost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeInt(mCost);
    }
}
