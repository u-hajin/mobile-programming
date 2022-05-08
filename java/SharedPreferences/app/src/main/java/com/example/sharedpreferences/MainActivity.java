package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // SharedPreferences
    // 임시로 저장하거나 앱이 지워지기 전까지 데이터를 남겨두기 위해
    // 앱 실행하고 EditText에 문자열 입력, 앱이 꺼져도 저장되게
    // 설정에서 많이 쓰인다. 푸쉬알림, 사운드 설정값들을 저장할 때
    // 앱을 삭제할 때는 다 사라진다.

    private EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        
        // 앱이 다시 켜졌을 때 불러오기
        String str = sharedPreferences.getString("usuyn","");
        et_save.setText(str);

    }

    @Override
    protected void onDestroy() { // ctrl + O, 앱을 종료했을 때 실행되는 함수
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String str = et_save.getText().toString(); // EditText에 입력한 문자열 받아오기
        editor.putString("usuyn", str); //usuyn이라는 이름으로 str을 저장, usuyn은 별명같은 것
        editor.commit(); // 저장을 완료.

    }
}