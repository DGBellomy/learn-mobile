package com.gbellomy.pointsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dbellomy on 10/16/17.
 */

public class RemovePointsActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
}
