package com.gbellomy.pointsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by gbellomy on 9/28/17.
 */

public class SpendPointsActivity extends AppCompatActivity {
    public int usedPoints = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_list);

        if (findViewById(R.id.frag_list_container) != null && savedInstanceState == null) {
            SpendListFragment spendListFragment = new SpendListFragment();
            spendListFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction()
                    .add(R.id.frag_list_container, spendListFragment)
                    .commit();
        }
    }

    public void onSubmitClicked(View view) {
        PointsData.getInstance(this).removePoints(usedPoints);
        PointsData.getInstance(this).save();
        startActivity(new Intent(this, HomeActivity.class));
    }
}
