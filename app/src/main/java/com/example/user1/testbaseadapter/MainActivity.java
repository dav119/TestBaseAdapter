package com.example.user1.testbaseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int MY_OBJECT_SIZE = 10000;

    ArrayList<MyObject> myObjectArrayList;
    MyAdapter myAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myObjectArrayList = new ArrayList<>();
        fillMyObjectArrayList(myObjectArrayList);

        myAdapter = new MyAdapter(this, myObjectArrayList);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myAdapter);

    }

    private void fillMyObjectArrayList(ArrayList<MyObject> myObjectArrayList) {
        Random random = new Random();

        for (int i = 0; i < MY_OBJECT_SIZE; i++) {
            myObjectArrayList.add(new MyObject("Name " + String.valueOf(i+1), "Surname "  + String.valueOf(i+1), random.nextBoolean()));
        }
    }
}
