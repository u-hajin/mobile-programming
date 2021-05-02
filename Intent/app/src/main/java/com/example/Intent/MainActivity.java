package com.example.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    private  String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml 파일이 연결되어 있다.

        et_test = findViewById(R.id.et_test);

        btn_move = findViewById(R.id.btn_move); // main.xml에 존재하는 btn_move를 연결
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_test.getText().toString(); // EditText에 입력된 문자열을 가져온다. String으로 변환해야 한다.
                Intent intent = new Intent(MainActivity.this, SubActivity.class); // 현재 자신의 위치, 가고 싶은 위치
                intent.putExtra("str", str);// putExtra로 Activity 이동 전 str 데이터를 담은 것.
                startActivity(intent); // Activity 이동하게 해주는 구문.
            }
        });
    }
}