package com.zorax.wms.setting.presenter;

import com.zorax.wms.base.BasePresenter;
import com.zorax.wms.base.WMSTask;

import java.util.ArrayList;

/**
 * @创作者 czp
 * @创作时间 2021/6/22 14:45
 * @描述
 */
public class SettingActivityPresenter extends BasePresenter<ISettingActivityContract.IView> implements ISettingActivityContract.IPresenter {

    public SettingActivityPresenter(ISettingActivityContract.IView view) {
        super(view);
    }

    @Override
    public void getWarehouse() {
    }

    @Override
    protected ISettingActivityContract.IView getEmptyView() {
        return ISettingActivityContract.view;
    }
}
