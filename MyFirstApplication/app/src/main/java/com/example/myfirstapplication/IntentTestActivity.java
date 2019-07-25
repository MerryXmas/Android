package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);
        findViewById(R.id.sqlite_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentTestActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.sp_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentTestActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.textv_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentTestActivity.this,ForthActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.layout_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentTestActivity.this,ThirdActivity.class);
                startActivity(intent);

            }
        });
        findViewById(R.id.grid_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentTestActivity.this,GridLayoutActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.table_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentTestActivity.this, TableLayoutActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.webv_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentTestActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.http_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentTestActivity.this, HttpTestActivity.class);
                startActivity(intent);
            }
        });


    }
}
