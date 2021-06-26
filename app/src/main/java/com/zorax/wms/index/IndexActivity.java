package com.zorax.wms.index;

import android.view.View;
import android.widget.RadioButton;

import com.zorax.mvp.ILifeCircle;
import com.zorax.mvp.IMvpView;
import com.zorax.wms.R;
import com.zorax.wms.base.BaseActivity;
import com.zorax.wms.base.BasePresenter;
import com.zorax.wms.base.ViewInject;


import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_index)
public class IndexActivity extends BaseActivity {

    @BindView(R.id.index_rb_instore)
    RadioButton indexRbInstore;
    @BindView(R.id.index_rb_outstore)
    RadioButton indexRbOutstore;
    @BindView(R.id.index_rb_check)
    RadioButton indexRbCheck;
    @BindView(R.id.index_rb_prepare)
    RadioButton indexRbPrepare;
    @BindView(R.id.index_rb_sales_return)
    RadioButton indexRbSalesReturn;
    @BindView(R.id.index_rb_setting)
    RadioButton indexRbSetting;

    //    IndexActivityPresenter mIndexActivityPresenter = new IndexActivityPresenter(this);
    ILifeCircle mPresenter = new BasePresenter(this) {
        @Override
        protected IMvpView getEmptyView() {
            return null;
        }
    };

    public static int layout;

    @Override
    public void afterBindView() {
    }


    @OnClick({R.id.index_rb_instore, R.id.index_rb_outstore, R.id.index_rb_check, R.id.index_rb_prepare, R.id.index_rb_sales_return, R.id.index_rb_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.index_rb_instore:
                layout  = R.id.index_rb_instore;
                break;
            case R.id.index_rb_outstore:
                break;
            case R.id.index_rb_check:
                layout = R.id.index_rb_check;
                break;
            case R.id.index_rb_prepare:
                break;
            case R.id.index_rb_sales_return:
                break;
            case R.id.index_rb_setting:
                layout = R.id.index_rb_setting;
                break;
        }
        mPresenter.toActivity(IndexActivity.this,layout);
        //        finish();
    }
}
