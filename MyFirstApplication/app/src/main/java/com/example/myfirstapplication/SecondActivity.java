package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Context.MODE_APPEND;

public class SecondActivity extends AppCompatActivity {
    private Button readButton = null;
    private Button writeButton = null;
    private Button testButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        readButton = (Button)findViewById(R.id.read_btn);
        writeButton = (Button)findViewById(R.id.write_btn);
        testButton = (Button)findViewById(R.id.test_btn);

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,"开始写入数据",Toast.LENGTH_LONG).show();
                @SuppressLint("WrongConstant") SharedPreferences settings = getSharedPreferences("String", MODE_APPEND);

                SharedPreferences.Editor editor = settings.edit();
//                editor.putString("name","张三");
                editor.putString("name","李四");
                editor.putString("password","12345");
                editor.putInt("age",23);
                editor.putBoolean("married",false);
                editor.commit();
                final boolean commit = editor.commit();
                if (commit){
                    Toast.makeText(SecondActivity.this,"写入成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SecondActivity.this,"写入失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,"开始读取数据",Toast.LENGTH_LONG).show();
                SharedPreferences settings = getSharedPreferences("String",0);
                String name = settings.getString("name","默认值");
                String password = settings.getString("password","默认值");
                int age = settings.getInt("age",0);
                Boolean married = settings.getBoolean("married",false);
                System.out.println("读取的数据值为:用户"+name+"的password为"+password+",年龄为"+age+"，是否结婚:"+married);
            }
        });

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,"点击正常",Toast.LENGTH_SHORT).show();
                System.out.println("测试点击正常");
            }
        });

    }
}
