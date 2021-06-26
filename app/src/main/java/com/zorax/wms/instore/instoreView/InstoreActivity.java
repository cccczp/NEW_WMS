package com.zorax.wms.instore.instoreView;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.zorax.wms.R;
import com.zorax.wms.base.BaseActivity;
import com.zorax.wms.base.ViewInject;
import com.zorax.wms.instore.index.InstoreIndexActivity;
import com.zorax.wms.tool.InstoreConstantTool;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_instore_public)
public class InstoreActivity extends BaseActivity implements IInstoreActivityContract.IView {

    @BindView(R.id.toolbar_ll_tv)
    TextView toolbarLlTv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.instore_public_et)
    EditText instorePublicEt;
    @BindView(R.id.instore_public_rb_left)
    RadioButton instorePublicRbLeft;
    @BindView(R.id.instore_public_rb_right)
    RadioButton instorePublicRbRight;
    @BindView(R.id.instore_public_fl)
    FrameLayout instorePublicFl;

    IInstoreActivityContract.IPresenter mPresenter = new InstoreActivityPresenter(this);

    @Override
    public void afterBindView() {
        initView();
        initHomeFragment();
    }

    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    private void initView() {
        mPresenter.setText(toolbarLlTv, InstoreIndexActivity.index);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.toActivity(InstoreActivity.this, R.layout.activity_instore_index);
            }
        });
        instorePublicRbLeft.setChecked(true);
        SharedPreferences sharedPreferences = this.getSharedPreferences("asn",this.MODE_PRIVATE);
        String asn = sharedPreferences.getString("asn", null);
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.instore_public_fl, fragment).commit();
    }

    @OnClick({R.id.instore_public_rb_left, R.id.instore_public_rb_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.instore_public_rb_left:
                if (mPresenter.getCurFragmentIndex() == InstoreConstantTool.ORDERMSG)
                {
                    return;
                }
                mPresenter.replaceFragment(InstoreConstantTool.ORDERMSG);
                break;
            case R.id.instore_public_rb_right:
                if (mPresenter.getCurFragmentIndex() != InstoreConstantTool.ORDERMSG)
                {
                    return;
                }
                switch (InstoreIndexActivity.index){
                    case R.id.instore_index_location:
                        mPresenter.replaceFragment(InstoreConstantTool.INSTOREMSG_LOC);
                        break;
                    case R.id.instore_index_tray:
                        mPresenter.replaceFragment(InstoreConstantTool.INSTOREMSG_TRAY);
                        break;
                    case R.id.instore_index_materialBarcde:
                        mPresenter.replaceFragment(InstoreConstantTool.INSTOREMSG_MATERIALBARCODE);
                        break;
                }
                break;
        }
    }
}
