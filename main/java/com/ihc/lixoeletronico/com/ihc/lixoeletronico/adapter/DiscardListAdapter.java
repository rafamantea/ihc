package com.ihc.lixoeletronico.com.ihc.lixoeletronico.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ihc.lixoeletronico.R;
import com.ihc.lixoeletronico.com.ihc.lixoeletronico.model.DiscardPlace;
import com.ihc.lixoeletronico.com.ihc.lixoeletronico.model.MockDatabase;

import java.util.List;

/**
 * Created by I852842 on 06/06/2017.
 */

public class DiscardListAdapter extends BaseAdapter {

    private final AppCompatActivity context;

    public DiscardListAdapter(AppCompatActivity context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return MockDatabase.getInstance().getAllPlaces().size();
    }

    @Override
    public Object getItem(int position) {
        return MockDatabase.getInstance().getAllPlaces().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = context.getLayoutInflater();
        final View listItem = inflater.inflate(R.layout.discards_list_item, parent, false);

        final TextView placeNameText = (TextView) listItem.findViewById(R.id.discard_item_name);
        final TextView addressText = (TextView) listItem.findViewById(R.id.discard_item_address);
        final TextView distanceText = (TextView) listItem.findViewById(R.id.discard_item_distance);

        final DiscardPlace place = MockDatabase.getInstance().getAllPlaces().get(position);
        final String name = place.getName();
        final String address = place.getAddress();
        final String distance = "2.10 Km";

        placeNameText.setText(name);
        addressText.setText(address);
        distanceText.setText(distance);

        return listItem;
    }
}