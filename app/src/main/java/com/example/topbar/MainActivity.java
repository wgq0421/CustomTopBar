package com.example.topbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WidgetTopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topBar = (WidgetTopBar) findViewById(R.id.topBar);
        topBar.getLeftBtnImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了返回",Toast.LENGTH_SHORT).show();
            }
        });

        topBar.getTitile().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topBar.setTitle("标题改变");
            }
        });

    }
}
