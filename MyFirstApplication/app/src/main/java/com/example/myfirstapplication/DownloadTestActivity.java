package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownloadTestActivity extends AppCompatActivity {
    private Button downloadBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_test);
        downloadBtn = findViewById(R.id.download_btn);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    downLoad("https://cloud-minapp-19338.cloud.ifanrusercontent.com/1gDPXXxlxaNvsriu.PNG",
                            DownloadTestActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void downLoad(String path, Context context)throws Exception
    {
        URL url = new URL(path);
        InputStream is = url.openStream();
        //截取最后的文件名
        String end = path.substring(path.lastIndexOf("."));
        //打开手机对应的输出流,输出到文件中
        OutputStream os = context.openFileOutput("Cache_"+System.currentTimeMillis()+end, Context.MODE_PRIVATE);
        byte[] buffer = new byte[1024];
        int len = 0;
        //从输入六中读取数据,读到缓冲区中
        while((len = is.read(buffer)) > 0)
        {
            os.write(buffer,0,len);

        }
        //关闭输入输出流
        is.close();
        os.close();
    }
}
