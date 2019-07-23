package com.example.myfirstapplication;

import android.content.Context;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class StuDBHelper extends SQLiteOpenHelper {
    Context mcontext;
    private static String createStuTable="create table student(" +
            "id integer primary key autoincrement," +
            "name varchar(16)," +
            "password varchar(16),"+
            "date varchar(16))";
    private static String createTeaTable="create table teacher(" +
            "id integer primary key autoincrement," +
            "name varchar(16)," +
            "password varchar(16))";
    public StuDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mcontext=context;
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(createStuTable);
        Toast.makeText(mcontext,"stu数据库已创建",Toast.LENGTH_LONG).show();
//        db.execSQL(createTeaTable);
//        Toast.makeText(mcontext,"teacher数据库已创建",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists student");
//        db.execSQL("drop table if exists teacher");
//        onCreate(db);

        System.out.println("数据库已更新,当前版本为"+newVersion+"之前版本为："+oldVersion);
        Toast.makeText(mcontext,"数据库已更新,当前版本为"+newVersion+"之前版本为："+oldVersion,Toast.LENGTH_SHORT).show();
    }
}