package com.gbellomy.pointsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by gbellomy on 10/1/17.
 */

public class SpendItemsAdapter extends ArrayAdapter<SpendItem> {
    private ArrayList<SpendItem> spendItems;
    private Context context;

    private class ViewHolder {
        TextView display;
    }

    SpendItemsAdapter(Context context, ArrayList<SpendItem> spendItems) {
        super(context, android.R.layout.simple_list_item_activated_1);
        this.context = context;
        this.spendItems = spendItems;
    }

    @Nullable
    @Override
    public SpendItem getItem(int position) {
        return this.spendItems.get(position);
    }

    @Override
    public int getCount() {
        return this.spendItems.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.spend_list_item, parent, false);

            viewHolder.display = convertView.findViewById(R.id.spend_display);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SpendItem spendItem = this.getItem(position);
        viewHolder.display.setText(String.format(Locale.US, "%s - %d pts", spendItem.getTitle(), spendItem.getCost()));
        parent.setBackgroundColor(ContextCompat.getColor(context, R.color.basic));

        return convertView;
    }
}
