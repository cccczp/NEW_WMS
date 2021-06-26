package com.zorax.wms.login;


import com.zorax.mvp.ILifeCircle;
import com.zorax.mvp.IMvpView;
import com.zorax.mvp.MvpControler;

/**
 * @创作者 czp
 * @创作时间 2021/5/29 16:18
 * @描述
 */
public interface ILoginActivityContract {
    interface IView extends IMvpView {

    }

    interface IPresenter extends ILifeCircle {

    }

    IView iView = new IView() {

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };

}
