package com.zorax.wms.check;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.zorax.mvp.ILifeCircle;
import com.zorax.mvp.IMvpView;
import com.zorax.wms.R;
import com.zorax.wms.base.BaseActivity;
import com.zorax.wms.base.BasePresenter;
import com.zorax.wms.base.ViewInject;

import butterknife.BindView;

@ViewInject(mainLayoutId = R.layout.activity_check_index)
public class CheckIndexActivity extends BaseActivity implements IMvpView {

    @BindView(R.id.toolbar_ll_tv)
    TextView toolbarLlTv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.check_index_day)
    RadioButton checkIndexDay;
    @BindView(R.id.check_index_total)
    RadioButton checkIndexTotal;

    ILifeCircle mCircle = new BasePresenter<IMvpView>(this) {
        @Override
        protected IMvpView getEmptyView() {
            return null;
        }
    };

    @Override
    public void afterBindView() {
          initLisenter();
    }

    private void initLisenter()
    {
        mCircle.setText(toolbarLlTv,R.id.index_rb_check);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(R.layout.activity_index);
            }
        });
        checkIndexDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             toActivity(R.id.check_index_day);
            }
        });
    }

    private void toActivity(int id)
    {
        mCircle.toActivity(CheckIndexActivity.this,id);
    }
}
