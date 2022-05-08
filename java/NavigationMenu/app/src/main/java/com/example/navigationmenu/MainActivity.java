package com.example.navigationmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;
    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout); // activity_main.xml
        drawerView = findViewById(R.id.drawer); // activity_drawer.xml

        Button btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(drawerView);
            }
        });

        drawerLayout.setDrawerListener(listener);

        drawerView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    // Drawer의 상태에 따라 각 함수를 호출.
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) { // slide 했을 때 호출

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
            cnt++;
            if(cnt > 10){
                Snackbar.make(drawerView, "Stop..", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                cnt = 0;
                return;
            }
            Snackbar.make(drawerView, "Open", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
            cnt++;
            Snackbar.make(drawerView, "Close", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}