package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button writeBtn = null;
    private Button readBtn = null;
    private Button createBtn = null;
    private Button deleteBtn = null;
    private EditText data = null;
    private ListView dataList = null;
    private String str = "";//text区域显示的数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        writeBtn = (Button)findViewById(R.id.write_btn);
        readBtn = (Button)findViewById(R.id.read_btn);
        createBtn = (Button)findViewById(R.id.create_btn);
        deleteBtn = (Button)findViewById(R.id.delete_btn);
        dataList = (ListView)findViewById(R.id.list_Data);
        data = (EditText)findViewById(R.id.data);

        //点击按钮创建数据库
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               StuDBHelper dbHelper = new StuDBHelper(MainActivity.this, "School.db", null, 1);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
//               TestDB dbTest = new TestDB(MainActivity.this,"School.db",null,1);
//               SQLiteDatabase db = dbTest.getWritableDatabase();
               ContentValues values = new ContentValues();
               values.put("name", "Wangxiaoxiao");
                db.update("student",values,"id = ?",new String[]{"1"});

            }
        });
        //点击按钮插入数据到stu数据表
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                Date curDate = new Date(System.currentTimeMillis());
                String date = format.format(curDate);
                //获取时间并转换格式
                StuDBHelper dbHelper = new StuDBHelper(MainActivity.this, "School.db",null,1);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                ContentValues value = new ContentValues();
                value.put("name", "chen");
                value.put("password", "12345");
                value.put("date",date);
                db.insert("student",null,value);
                value.clear();
                value.put("name","wang");
                value.put("password","34567");
                value.put("date",date);
                db.insert("student",null,value);

                Toast.makeText(MainActivity.this,
                        "存储数据成功", Toast.LENGTH_SHORT).show();
            }
        });
        //读取数据库stu表内容并打印
        readBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //定义一个链表存放数据
                final List<String> adapterData = new ArrayList<String>();

                StuDBHelper dbHelper = new StuDBHelper(MainActivity.this,"School.db",null,1);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor cursor = db.query("student",null,null,null,null,null,null);
                while (cursor.moveToNext()){
                    String id = cursor.getString(cursor.getColumnIndex("id"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String password = cursor.getString(cursor.getColumnIndex("password"));
                    String date = cursor.getString(cursor.getColumnIndex("date"));
                    System.out.println("查询到的数据是:id:"+id+",name:"+name+",password:"+password+",date:"+date);
                    str = str + "查询到的数据是:id:"+id+",name:"+name+",password:"+password+",date:"+date+"\n";
                    adapterData.add("查询到的数据是:id:"+id+",name:"+name+",password:"+password+",date:"+date);

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,adapterData);
                dataList.setAdapter(adapter);
                data.setText(str);
            }
        });
        //删除数据库
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDatabase("School.db");
                str = null;
                data.setText(str);
                Toast.makeText(MainActivity.this,"数据库已删除",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
