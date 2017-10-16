package com.gbellomy.pointsapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by gbellomy on 9/28/17.
 */

public class SpendListFragment extends ListFragment {
    private static final String SPEND_ITEMS_ARG = "spend_items";
    private ArrayList<SpendItem> spendItems = new ArrayList<>();
    private PointsData pointsData = PointsData.getInstance();
    private SpendItemsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new SpendItemsAdapter(getActivity(), spendItems);
        setListAdapter(adapter);

        for (Map.Entry<String, Integer> entry : pointsData.getRewards().entrySet()) {
            spendItems.add(new SpendItem(entry.getKey(), entry.getValue()));
        }
        /*
        if (savedInstanceState == null || !savedInstanceState.containsKey(SPEND_ITEMS_ARG)) {
        } else {
            spendItems = savedInstanceState.getParcelableArrayList(SPEND_ITEMS_ARG);
        }
        */

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        SpendItem spendItem = adapter.getItem(position);
        SpendPointsActivity activity = (SpendPointsActivity) getActivity();
        if (spendItem.getCost() + activity.usedPoints > pointsData.getPoints()) {
            Toast.makeText(activity, "Not enough points", Toast.LENGTH_SHORT).show();
        } else {
            activity.usedPoints += spendItem.getCost();
            // make inactive
        }
    }

    /*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(SPEND_ITEMS_ARG, spendItems);
        super.onSaveInstanceState(outState);
    }
    */
}
