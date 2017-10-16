package com.gbellomy.pointsapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by gbellomy on 9/28/17.
 */

public class SpendListFragment extends ListFragment {
    private static final String SPEND_ITEMS_ARG = "spend_items";
    private ArrayList<SpendItem> spendItems = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SpendItemsAdapter adapter = new SpendItemsAdapter(getActivity(), spendItems);
        setListAdapter(adapter);

        if (savedInstanceState == null || !savedInstanceState.containsKey(SPEND_ITEMS_ARG)) {
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
            spendItems.add(new SpendItem("Lego StarWars", 15));
        } else {
            spendItems = savedInstanceState.getParcelableArrayList(SPEND_ITEMS_ARG);
        }

        adapter.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(SPEND_ITEMS_ARG, spendItems);
        super.onSaveInstanceState(outState);
    }
}
