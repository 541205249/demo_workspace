package com.example.utilsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fileName = dealFileName("test.apk", ".apk");
        Log.i("jzy", fileName);
    }

    private String dealFileName(String fileName, String fileExtension) {
        if(fileName.contains(fileExtension)) {
            fileName = fileName.replace(fileExtension, "");
        }

        return fileName;
    }
}
