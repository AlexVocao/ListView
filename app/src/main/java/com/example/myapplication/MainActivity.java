package com.example.myapplication;

import static java.util.Arrays.asList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView friendListView;
    ArrayList<String> friendArrayList;
    ArrayAdapter<String> friendArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testing();
    }

    public void init(){
        initView();
        initData();
    }
    public void initView(){
        friendListView = (ListView) findViewById(R.id.friendListView);
    }

    public void initData(){
        friendArrayList = new ArrayList<String>(asList("Max", "Mongo", "Sin", "Tako"));
        friendArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friendArrayList);
    }

    public void showFriendList(){
        friendListView.setAdapter(friendArrayAdapter);
    }
    public void  selectFriend(){
        friendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Friend: "+ friendArrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void testing(){
        init();
        showFriendList();
        selectFriend();
    }
}