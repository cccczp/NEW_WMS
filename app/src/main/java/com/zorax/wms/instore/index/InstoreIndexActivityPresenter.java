package com.zorax.wms.instore.index;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zorax.mvp.base.BaseMvpPresenter;
import com.zorax.wms.R;
import com.zorax.wms.base.BasePresenter;
import com.zorax.wms.instore.adapter.InstoreAdapter;
import com.zorax.wms.instore.dto.InstoreBean;
import com.zorax.wms.instore.index.IInstoreIndexActivityContract;

/**
 * @创作者 czp
 * @创作时间 2021/6/8 11:13
 * @描述
 */
public class InstoreIndexActivityPresenter extends BasePresenter<IInstoreIndexActivityContract.IView> implements IInstoreIndexActivityContract.IPresenter {

    public InstoreIndexActivityPresenter(IInstoreIndexActivityContract.IView view) {
        super(view);
    }

    @Override
    protected IInstoreIndexActivityContract.IView getEmptyView() {
        return IInstoreIndexActivityContract.view;
    }

    @Override
    public void setText(TextView textView, int index) {
        super.setText(textView, index);
        switch (index) {

        }
    }

    @Override
    public void setOnItemLisenter(InstoreAdapter adapter) {
        InstoreAdapter.OnItemClickListener listener = new InstoreItem();
        adapter.setOnItemClickLitener(listener);
    }


    public class InstoreItem implements InstoreAdapter.OnItemClickListener {

        @Override
        public void onItemClick(View view,String asn, int position) {
             getView().setAsn(asn);
        }
    }
}
