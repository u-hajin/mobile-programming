package com.example.imageview_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView test;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        test = findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count > 10)
                    Toast.makeText(getApplicationContext(), "그만 누르세요..", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "눌렀다!", Toast.LENGTH_SHORT).show();
                //getApplicationContext는 MainActivity를 뜻한다.
            }
        });
    }
}