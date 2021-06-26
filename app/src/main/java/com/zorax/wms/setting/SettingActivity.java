package com.zorax.wms.setting;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.zorax.wms.R;
import com.zorax.wms.base.BaseActivity;
import com.zorax.wms.base.ViewInject;
import com.zorax.wms.index.IndexActivity;
import com.zorax.wms.setting.presenter.ISettingActivityContract;
import com.zorax.wms.setting.presenter.SettingActivityPresenter;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_setting)
public class SettingActivity extends BaseActivity implements ISettingActivityContract.IView {

    @BindView(R.id.setting_address_et)
    Button settingAddressEt;
    @BindView(R.id.setting_about_et)
    Button settingAboutEt;
    @BindView(R.id.setting_logout_et)
    Button settingLogoutEt;
    //    @BindView(R.id.setting_rv)
    //    RecyclerView settingRv;
    @BindView(R.id.setting_rl)
    FrameLayout settingRl;
    @BindView(R.id.toolbar_ll_tv)
    TextView toolbarLlTv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.setting_rg)
    RadioGroup settingRg;
    @BindView(R.id.setting)
    LinearLayout setting;

    ISettingActivityContract.IPresenter mIPresenter = new SettingActivityPresenter(this);


    @Override
    public void afterBindView() {
        initLisenter();
        initRecyclerView();
    }

    private void initLisenter() {
        mIPresenter.setText(toolbarLlTv, IndexActivity.layout);
        settingRl.setVisibility(View.GONE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIPresenter.toActivity(SettingActivity.this, R.layout.activity_index);
            }
        });
    }

    private void initRecyclerView() {
        //        settingRv.setLayoutManager(new LinearLayoutManager(SettingActivity.this));
        //        settingRv.setAdapter(new SettingAdapter(WarehouseDataManager.getData()));
        for (int i = 0; i < 5; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(i + "");
            settingRg.addView(radioButton);
        }
        mIPresenter.getWarehouse();
    }

    @OnClick({R.id.setting_address_et, R.id.setting_about_et, R.id.setting_logout_et, R.id.setting, R.id.setting_rg})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_address_et:
                if (settingRl.getVisibility() == View.GONE) {
                    settingRl.setVisibility(View.VISIBLE);
                } else {
                    settingRl.setVisibility(View.GONE);
                }
                break;
            case R.id.setting_about_et:
                break;
            case R.id.setting_logout_et:
                break;
            case R.id.setting_rg:
                settingRl.setVisibility(View.GONE);
                RadioButton radioButton = findViewById(settingRg.getCheckedRadioButtonId());
                settingAddressEt.setText(radioButton.getText());
                break;
            case R.id.setting:
                if (settingRl.getVisibility() == View.VISIBLE) {
                    settingRl.setVisibility(View.GONE);
                }
                break;
        }
    }
}
