package com.example.edittext_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // xml의 id와 유사하게 하는 것이 좋다.
    EditText et_id;
    Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id); // 특정 id에게 속성 부여, xml 파일의 et_id와 연결이 된 것.
        btn_test = findViewById(R.id.btn_test);

        btn_test.setOnClickListener(new View.OnClickListener() { // 버튼 클릭시 상호작용
            @Override
            public void onClick(View v) {
                et_id.setText("반갑습니다."); // 버튼 클릭시 텍스트 입력창에 "반갑습니다." 입력된다.
            }
        });
    }
}