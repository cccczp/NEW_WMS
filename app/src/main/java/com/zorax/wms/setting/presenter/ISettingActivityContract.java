package com.zorax.wms.setting.presenter;

import com.zorax.mvp.ILifeCircle;
import com.zorax.mvp.IMvpView;
import com.zorax.mvp.MvpControler;

import java.util.ArrayList;

/**
 * @创作者 czp
 * @创作时间 2021/6/22 14:46
 * @描述
 */
public interface ISettingActivityContract {
    interface IView extends IMvpView {

    }

    interface IPresenter extends ILifeCircle {

        void getWarehouse();
    }

    IView view = new IView() {
        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
