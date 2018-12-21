package com.example.asus.myapplication.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.myapplication.R;

public class JiaJianView extends LinearLayout implements View.OnClickListener {

    private ImageView jian;
    private TextView num;
    private ImageView jia;
    int count=0;

    public JiaJianView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.jiajianview,this);
        initView();


    }
    //给num赋集合中原本的数量
    public void setCount(int count) {
        this.count = count;
        if(count==0){
            num.setVisibility(GONE);
            jian.setVisibility(GONE);
        }else{
            num.setVisibility(VISIBLE);
            jian.setVisibility(VISIBLE);
        }
        num.setText(count+"");
    }

    private void initView() {
        jian = findViewById(R.id.imgae_jian);
        num = findViewById(R.id.num);
        jia = findViewById(R.id.imgae_jia);
        jian.setOnClickListener(this);
        jia.setOnClickListener(this);
    }

    //接口回调
    CountCallBack countCallBack;
    public interface CountCallBack{
        void setCount(int count);
    }

    public void getCount(CountCallBack countCallBack) {
        this.countCallBack=countCallBack;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgae_jian:
                if(count>0){
                    count--;
                    num.setText(count+"");
                    if(countCallBack!=null){
                        countCallBack.setCount(count);
                    }
                }
                if(count==0){
                        num.setVisibility(GONE);
                        jian.setVisibility(GONE);

                }
                break;
            case R.id.imgae_jia:
                count++;
                num.setVisibility(VISIBLE);
                jian.setVisibility(VISIBLE);
                num.setText(count+"");
                if(countCallBack!=null){
                    countCallBack.setCount(count);
                }
                break;

        }

    }
}
