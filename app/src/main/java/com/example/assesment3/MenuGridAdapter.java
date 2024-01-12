package com.example.assesment3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

// MenuGridAdapter.java
public class MenuGridAdapter extends BaseAdapter {

    private Context context;
    private List<MenuItem> menuItems;

    public MenuGridAdapter(Context context, List<MenuItem> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item_menu, parent, false);
        }

        ImageView iconImageView = convertView.findViewById(R.id.iconImageView);
        TextView titleTextView = convertView.findViewById(R.id.titleTextView);

        MenuItem menuItem = menuItems.get(position);
        iconImageView.setImageResource(menuItem.getIconResId());
        titleTextView.setText(menuItem.getTitle());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NextActivity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
