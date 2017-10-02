package com.gbellomy.pointsapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by gbellomy on 9/28/17.
 */

public class SpendListFragment extends ListFragment {
    private static final String SPEND_ITEMS_ARG = "spend_items";
    private ArrayList<SpendItem> spendItems;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null || !savedInstanceState.containsKey(SPEND_ITEMS_ARG)) {
            spendItems = new ArrayList<>();
            spendItems.add(new SpendItem("Lego StarWars", 15));
        } else {
            spendItems = savedInstanceState.getParcelableArrayList(SPEND_ITEMS_ARG);
        }

        ListAdapter adapter = new SpendItemsAdapter(getActivity(), spendItems);
        setListAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(SPEND_ITEMS_ARG, spendItems);
        super.onSaveInstanceState(outState);
    }
}
