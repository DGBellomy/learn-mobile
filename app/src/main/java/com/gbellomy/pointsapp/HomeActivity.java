package com.gbellomy.pointsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by gbellomy on 9/28/17.
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void onSpendPointsClicked(View view) {
        startActivity(new Intent(this, SpendPointsActivity.class));
    }

    public void onAddPointsClicked(View view) {
        startActivity(new Intent(this, AddPointsActivity.class));
    }

    public void onRemovePointsClicked(View view) {
        startActivity(new Intent(this, RemovePointsActivity.class));
    }
}
