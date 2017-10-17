package com.gbellomy.pointsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by gbellomy on 9/28/17.
 */

public class HomeActivity extends AppCompatActivity {
    PointsData pointsData;
    TextView totalPointsDisplay;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        pointsData = PointsData.getInstance(this);
        pointsData.load();
        totalPointsDisplay = (TextView) findViewById(R.id.total_points_display);
        setTotalPointsDisplay();
    }

    public void onSpendPointsClicked(View view) {
        startActivity(new Intent(this, SpendPointsActivity.class));
    }

    public void onAddPointsClicked(View view) {
        //startActivity(new Intent(this, AddPointsActivity.class));
        pointsData.addPoints(1);
        setTotalPointsDisplay();
    }

    public void onRemovePointsClicked(View view) {
        //startActivity(new Intent(this, RemovePointsActivity.class));
        pointsData.removePoints(1);
        setTotalPointsDisplay();
    }

    private void setTotalPointsDisplay()
    {
        totalPointsDisplay.setText("Total Points: " + pointsData.getPoints());
    }

    @Override
    protected void onPause() {
        super.onPause();
        pointsData.save();
    }
}
