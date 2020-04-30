package com.example.cookingbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    ArrayList<Food> list;
    int layout;
    Context context;

    public FoodAdapter(ArrayList<Food> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        ImageView imageView1, imageView2;
        TextView textView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView1 = convertView.findViewById(R.id.imageView1);
            viewHolder.imageView2 = convertView.findViewById(R.id.imageView2);
            viewHolder.textView = convertView.findViewById(R.id.textTitle);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.imageView1.setImageResource(list.get(position).imageView1);
        viewHolder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebView.class);
                intent.putExtra("link",list.get(position).link);
                context.startActivity(intent);
            }
        });

        viewHolder.imageView2.setImageResource(list.get(position).imageView2);
        viewHolder.textView.setText(list.get(position).title);
        viewHolder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LoadImage.class);
                intent.putExtra("imageID", list.get(position).bigImage);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
