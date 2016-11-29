package com.example.user1.testbaseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int MY_OBJECT_SIZE = 10000;

    ArrayList<MyObject> myObjectArrayList;
    Random random;
    MyAdapter myAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myObjectArrayList = new ArrayList<>();
        random = new Random();

        for (int i = 0; i < MY_OBJECT_SIZE; i++) {
            myObjectArrayList.add(new MyObject("Name " + i, "Surname " + i, random.nextBoolean()));
        }

        myAdapter = new MyAdapter(this, myObjectArrayList);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myAdapter);




    }
}
