package com.example.asus.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.asus.myapplication.adapter.LeftAdapter;
import com.example.asus.myapplication.adapter.RightAdapter;
import com.example.asus.myapplication.bean.MyData;
import com.example.asus.myapplication.presenter.PresenterImpl;
import com.example.asus.myapplication.view.IView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    private TextView price;
    private TextView jeisuan;
    private RecyclerView recy1;
    private RecyclerView recy2;
    List<MyData.DataBean> ldata = new ArrayList<>();
    private LeftAdapter ladapter;
    private PresenterImpl presenter;
    private RightAdapter radapter;
    private String mUrl = "http://www.wanandroid.com/tools/mockapi/6523/restaurant-list";
    private TextView right_shangjia;
    List<MyData.DataBean.SpusBean> spus=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        recy1.setLayoutManager(new LinearLayoutManager(this));
        recy2.setLayoutManager(new LinearLayoutManager(this));
        ladapter = new LeftAdapter(this, ldata);
        radapter = new RightAdapter(MainActivity.this, spus);
        recy1.setAdapter(ladapter);
        recy2.setAdapter(radapter);
        presenter = new PresenterImpl(this);
        presenter.startRequest(mUrl, 1);
        ladapter.setOnClick(new LeftAdapter.AdapterOnClick() {
            @Override
            public void onClick(View v, int position) {
                spus.clear();
                //给右边的适配器中的集合添加数据
                spus.addAll(ldata.get(position).getSpus());
                for (int i = 0; i < spus.size(); i++) {
                    spus.get(i).setPraise_num(0);
                }
                right_shangjia.setText(ldata.get(position).getName());
                radapter.notifyDataSetChanged();
                flushBottomLayout();
            }
        });
        radapter.setCallBack(new RightAdapter.AdapterCallBack() {
            @Override
            public void shuaxin() {
                flushBottomLayout();
            }
        });
    }
    public void flushBottomLayout(){
        price.setText(radapter.getGoodsPrice()+"");
    }

    private void initView() {
        price = (TextView) findViewById(R.id.price);
        jeisuan = (TextView) findViewById(R.id.jeisuan);
        recy1 = (RecyclerView) findViewById(R.id.recy1);
        recy2 = (RecyclerView) findViewById(R.id.recy2);
        right_shangjia = (TextView) findViewById(R.id.right_shangjia);
        //right_shangjia.setOnClickListener(this);
    }

    @Override
    public void successData(Object data) {
        MyData data1 = (MyData) data;
        ldata.addAll(data1.getData());
        ladapter.notifyDataSetChanged();
    }

    @Override
    public void errorMsg(Object error) {

    }
}
