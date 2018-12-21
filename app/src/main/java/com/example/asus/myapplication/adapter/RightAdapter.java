package com.example.asus.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.myapplication.MainActivity;
import com.example.asus.myapplication.R;
import com.example.asus.myapplication.bean.MyData;
import com.example.asus.myapplication.weight.JiaJianView;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    private Context mContext;
    List<MyData.DataBean.SpusBean> list;

    public RightAdapter(Context mContext, List<MyData.DataBean.SpusBean> list) {
        this.mContext = mContext;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(mContext, R.layout.right_item,null);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(mContext).load(list.get(i).getPic_url()).into(viewHolder.image);
        viewHolder.name.setText(list.get(i).getName());
        viewHolder.yueshou.setText(list.get(i).getMonth_saled()+"");
        viewHolder.price.setText(list.get(i).getSkus().get(0).getPrice());

        viewHolder.jianjian.setCount(list.get(i).getPraise_num());
        viewHolder.jianjian.getCount(new JiaJianView.CountCallBack() {
            @Override
            public void setCount(int count) {
                list.get(i).setPraise_num(count);
                adapterCallBack.shuaxin();

                notifyDataSetChanged();
            }
        });
    }
    public float getGoodsPrice(){
        float price=0;
        for (int i = 0; i < list.size(); i++) {
            price+=list.get(i).getPraise_num()*Float.valueOf(list.get(i).getSkus().get(0).getPrice());

        }
        return price;

    }

    AdapterCallBack adapterCallBack;
    public interface AdapterCallBack {
        void shuaxin();
    }
    public void setCallBack(AdapterCallBack adapterCallBack){
        this.adapterCallBack=adapterCallBack;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView yueshou;
        TextView price;
        JiaJianView jianjian;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.right_image);
            name=itemView.findViewById(R.id.sp_name);
            yueshou=itemView.findViewById(R.id.sp_yueshou);
            price=itemView.findViewById(R.id.sp_price);
            jianjian=itemView.findViewById(R.id.jiajian);
        }
    }
}
