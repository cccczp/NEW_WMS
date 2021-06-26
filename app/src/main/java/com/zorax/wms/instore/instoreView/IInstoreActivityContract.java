package com.zorax.wms.instore.instoreView;

import androidx.fragment.app.Fragment;

import com.zorax.mvp.ILifeCircle;
import com.zorax.mvp.IMvpView;
import com.zorax.mvp.MvpControler;


/**
 * @创作者 czp
 * @创作时间 2021/6/4 16:16
 * @描述
 */
public interface IInstoreActivityContract {
    interface IView extends IMvpView {

        void hideFragment(Fragment fragment);

        void showFragment(Fragment fragment);

        void addFragment(Fragment fragment);

    }

    interface IPresenter extends ILifeCircle {

        void initHomeFragment();

        void replaceFragment(int mCurFragmentIndex);

        int getCurFragmentIndex();
    }

    IView view = new IView() {

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
