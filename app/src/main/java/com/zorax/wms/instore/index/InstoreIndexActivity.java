package com.zorax.wms.instore.index;

import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zorax.wms.R;
import com.zorax.wms.base.BaseActivity;
import com.zorax.wms.base.ViewInject;
import com.zorax.wms.instore.adapter.InstoreAdapter;
import com.zorax.wms.instore.dto.InstoreBean;
import com.zorax.wms.instore.dto.InstoreBeanDataManager;
import com.zorax.wms.tool.MediaPlayerUtil;

import org.apache.commons.lang3.StringUtils;

import java.security.Provider;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_instore_index)
public class InstoreIndexActivity extends BaseActivity implements IInstoreIndexActivityContract.IView {

    @BindView(R.id.toolbar_ll_tv)
    TextView toolbarLlTv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.instore_index_location)
    RadioButton instoreIndexLocation;
    @BindView(R.id.instore_index_tray)
    RadioButton instoreIndexTray;
    @BindView(R.id.instore_index_materialBarcde)
    RadioButton instoreIndexMaterialBarcde;
    @BindView(R.id.activity_instore_index_recyclerview)
    RecyclerView activityInstoreIndexRecyclerview;

    IInstoreIndexActivityContract.IPresenter mIPresenter = new InstoreIndexActivityPresenter(this);
    InstoreAdapter mAdapter;
    public static int index;
    private String asn;
    private Vibrator mVibrator;
    private MediaPlayerUtil mediaPlayer;


    @Override
    public void afterBindView() {
        initToolbar();
        initLayManager();
    }

    @OnClick({R.id.instore_index_location, R.id.instore_index_tray, R.id.instore_index_materialBarcde})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.instore_index_location:
                index = R.id.instore_index_location;
                break;
            case R.id.instore_index_tray:
                index = R.id.instore_index_tray;
                break;
            case R.id.instore_index_materialBarcde:
                index = R.id.instore_index_materialBarcde;
                break;
        }
        if (StringUtils.isEmpty(asn))
        {
            errorWarn("请选择一个入库订单");
            return;
        }
        SharedPreferences sharedPreferences = this.getSharedPreferences("asn", this.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("asn",asn);
        edit.commit();
        mIPresenter.toActivity(InstoreIndexActivity.this, index);
    }

    private void initToolbar() {
        mIPresenter.setText(toolbarLlTv, R.layout.activity_instore_index);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIPresenter.toActivity(InstoreIndexActivity.this, R.layout.activity_index);
            }
        });
    }

    private void initLayManager() {
        mAdapter = new InstoreAdapter(InstoreBeanDataManager.getData());
        activityInstoreIndexRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        activityInstoreIndexRecyclerview.setAdapter(mAdapter);
        mIPresenter.setOnItemLisenter(mAdapter);
    }

    @Override
    public void setAsn(String asn) {
        this.asn = asn;
    }

    private void errorWarn(String msg)
    {
        if (mVibrator == null)
        {
            mVibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        }
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayerUtil(InstoreIndexActivity.this);
        }
        mIPresenter.showToast(InstoreIndexActivity.this, msg);
        mVibrator.vibrate(2000);
        mediaPlayer.start();
    }
}
