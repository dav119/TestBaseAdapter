package com.example.user1.testbaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by user1 on 29.11.2016.
 */

public class MyAdapter extends BaseAdapter {
    Context myContext;
    LayoutInflater myInflater;
    ArrayList<MyObject> myObjectArrayList;

    MyAdapter(Context context, ArrayList<MyObject> myObjectArrayList) {
        this.myContext = context;
        this.myObjectArrayList = myObjectArrayList;
        myInflater = LayoutInflater.from(myContext);
    }

    @Override
    public int getCount() {
        return myObjectArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return myObjectArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = myInflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MyObject myObject = (MyObject) getItem(position);

        viewHolder.name.setText(myObject.getName());
        viewHolder.surname.setText(myObject.getSurname());
        viewHolder.check.setChecked(myObject.getCheck());

        return convertView;
    }

    private class ViewHolder {
        TextView name;
        TextView surname;
        CheckBox check;

        ViewHolder(View view) {
            name = (TextView) view.findViewById(R.id.textName);
            surname = (TextView) view.findViewById(R.id.textSurname);
            check = (CheckBox) view.findViewById(R.id.checkBox);
        }
    }
}
