package com.example.asus.myapplication.presenter;


import com.example.asus.myapplication.callback.MyCallBack;
import com.example.asus.myapplication.modle.MoldeImpl;
import com.example.asus.myapplication.view.IView;

public class PresenterImpl implements Presenter {
    MoldeImpl molde;
    IView iView;

    public PresenterImpl(IView iView) {
        this.iView = iView;
        molde=new MoldeImpl();
    }

    @Override
    public void startRequest(String url, int type) {
        molde.getData(url, type, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iView.successData(data);
            }

            @Override
            public void setError(Object error) {

            }
        });


    }
}
