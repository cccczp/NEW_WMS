package com.zorax.wms.instore.index;

import com.zorax.mvp.ILifeCircle;
import com.zorax.mvp.IMvpView;
import com.zorax.mvp.MvpControler;
import com.zorax.wms.instore.adapter.InstoreAdapter;
import com.zorax.wms.instore.dto.InstoreBean;

/**
 * @创作者 czp
 * @创作时间 2021/6/8 11:14
 * @描述
 */
public interface IInstoreIndexActivityContract {
    interface IView extends IMvpView{

        void setAsn(String asn);
    }

    interface IPresenter extends ILifeCircle{

        void setOnItemLisenter(InstoreAdapter adapter);
    }

    IView view = new IView() {
        @Override
        public void setAsn(String asn) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
