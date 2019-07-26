package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterActivity extends AppCompatActivity {
    private String[] names = new String[]{"宝马","奔驰","奥迪"};
    private String[] info = new String[]{"新3系325Li","新C级C260L","A4L"};
    private int[] imgs = new int[]{R.drawable.icon,R.drawable.icon1,R.drawable.icon2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        String[] strs = {"宝马325Li","奔驰C260L","奥迪A4L","一汽大众CC"};
        String[] test = {"1","2","3","4","5"};
        ListView list_test = findViewById(R.id.list_test);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,test);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,strs);
//        测试ArrayAdapter显示效果
//        ListView list_test = findViewById(R.id.list_test);
//        list_test.setAdapter(adapter)
//        将数据加入到List中，以便于显示在simpleAdapter中
        List<Map<String, Object>> listItem = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < names.length; i++) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("img", imgs[i]);
            data.put("name", names[i]);
            data.put("info", info[i]);
            listItem.add(data);
            System.out.println(listItem);
        }
        //创建simpleAdapter，第三个参数是写好的列表布局行xml
        SimpleAdapter myAdapter = new SimpleAdapter(this,listItem, R.layout.simple_item,
                new String[]{"img","name","info"},
                new int[]{R.id.img,R.id.name,R.id.info});
        list_test.setAdapter(myAdapter);

    }
}
