package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview =  findViewById(R.id.listview);

        List<String> data = new ArrayList<>();

        // ArrayAdapter : 배열과 리스트뷰를 연결하는 클래스, 배열은 리스트뷰가 화면으로 뿌릴 자료들의 집합.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data); // 안드로이드에서 제공하는 List UI

        // list에 adapter를 세팅.
        listview.setAdapter(adapter);

        // 아이템 추가
        data.add("딸기");
        data.add("포도");
        data.add("바나나");

        // data 상태 저장
        adapter.notifyDataSetChanged();

    }}