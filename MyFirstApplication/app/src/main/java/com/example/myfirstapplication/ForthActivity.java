package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForthActivity extends AppCompatActivity {
    private TextView mtv4;
    private TextView mtv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
        mtv4 = findViewById(R.id.tv_4);
        mtv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        mtv4.getPaint().setAntiAlias(true);//去掉锯齿

        mtv5 = findViewById(R.id.tv_5);
        mtv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线

    }
}
