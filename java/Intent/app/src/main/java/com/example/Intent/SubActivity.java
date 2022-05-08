package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);

        Intent intent = getIntent(); // 어디선가 intent가 오면 받겠다.
        String str = intent.getStringExtra("str"); // MainAct에서 putExtra에 지정한 별명과 동일해야 한다.

        tv_sub.setText(str);
    }
}