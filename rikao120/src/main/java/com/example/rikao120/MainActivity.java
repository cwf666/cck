package com.example.rikao120;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.rikao120.weight.MyHeadView;

public class MainActivity extends AppCompatActivity {

    private MyHeadView headview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        headview.getData(new MyHeadView.ContentCallBack() {
            @Override
            public void setData(String name) {
                Toast.makeText(MainActivity.this, name+"", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initView() {
        headview = (MyHeadView) findViewById(R.id.headview);
    }
}
