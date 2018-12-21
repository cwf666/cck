package com.example.rikao120.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rikao120.R;

public class MyHeadView extends LinearLayout implements View.OnClickListener {
    private EditText ed_name;
    private TextView login;

    public MyHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.head_view, this);
        initView();
    }
    private void initView() {
        ed_name=findViewById(R.id.ed_name);
        login=findViewById(R.id.login);
        login.setOnClickListener(this);
    }
    ContentCallBack contentCallBack;
    public interface ContentCallBack{
        void setData(String name);
    }
    public void getData(ContentCallBack contentCallBack){
        this.contentCallBack=contentCallBack;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                String name=ed_name.getText().toString().trim();
                contentCallBack.setData(name);
                break;
        }


    }
}
