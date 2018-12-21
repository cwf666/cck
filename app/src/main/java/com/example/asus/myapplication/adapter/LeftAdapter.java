package com.example.asus.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.myapplication.R;
import com.example.asus.myapplication.bean.MyData;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder>implements View.OnClickListener {
    Context mContext;
    List<MyData.DataBean> data;

    public LeftAdapter(Context mContext, List<MyData.DataBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(mContext, R.layout.layout,null);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(i);
        viewHolder.tv.setText(data.get(i).getName());
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    @Override
    public void onClick(View v) {
        if(adapterOnClick!=null){
            adapterOnClick.onClick(v,(int)v.getTag());
        }


    }
    public interface AdapterOnClick{
        void onClick(View v,int position);
    }
    AdapterOnClick adapterOnClick;
    public void setOnClick(AdapterOnClick adapterOnClick){
        this.adapterOnClick=adapterOnClick;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.shangjia);
        }
    }
}
