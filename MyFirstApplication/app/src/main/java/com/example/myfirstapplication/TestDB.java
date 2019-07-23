package com.example.myfirstapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class TestDB extends SQLiteOpenHelper {
    private  Context mcontext;
    private  static  String sql = "create table stu("+
            "id integer primary key autoincrement,"+
            "name varchar(16),"+
            "password varchar(16),"+
            "date varchar(16))";

    public  TestDB(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        this.mcontext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
        Toast.makeText(mcontext,"stu表创建成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        Toast.makeText(mcontext,"数据库已更新",Toast.LENGTH_SHORT).show();
    }
}
