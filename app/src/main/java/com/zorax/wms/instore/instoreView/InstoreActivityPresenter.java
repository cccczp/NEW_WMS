package com.zorax.wms.instore.instoreView;

import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.zorax.mvp.base.BaseMvpPresenter;
import com.zorax.wms.R;
import com.zorax.wms.base.BasePresenter;
import com.zorax.wms.instore.fragment.LocationInstoreFragment;
import com.zorax.wms.instore.fragment.MaterialBarcodeInstoreFragment;
import com.zorax.wms.instore.fragment.OrderFragment;
import com.zorax.wms.instore.fragment.TrayInstoreFragment;
import com.zorax.wms.instore.instoreView.IInstoreActivityContract;
import com.zorax.wms.tool.InstoreConstantTool;

/**
 * @创作者 czp
 * @创作时间 2021/6/4 16:19
 * @描述
 */
public class InstoreActivityPresenter extends BasePresenter<IInstoreActivityContract.IView> implements IInstoreActivityContract.IPresenter {

    private int mCurFragmentIndex;
    private Fragment[] mFragments = new Fragment[4];

    public InstoreActivityPresenter(IInstoreActivityContract.IView view) {
        super(view);
    }

    @Override
    protected IInstoreActivityContract.IView getEmptyView() {
        return IInstoreActivityContract.view;
    }

    @Override
    public void initHomeFragment() {
        mCurFragmentIndex = InstoreConstantTool.ORDERMSG;
        replaceFragment(mCurFragmentIndex);
    }

    @Override
    public void replaceFragment(int mCurFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (mCurFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }
        Fragment fragment = mFragments[mCurFragmentIndex];
        if (fragment != null) {
            addAndShowFragment(fragment);
            setCurChecked(mCurFragmentIndex);
        } else {
            newFragment(mCurFragmentIndex);
            setCurChecked(mCurFragmentIndex);
        }
    }

    @Override
    public int getCurFragmentIndex() {
        return this.mCurFragmentIndex;
    }

    private void newFragment(int curFragmentIndex) {
        Fragment fragment = null;
        switch (curFragmentIndex) {
            case InstoreConstantTool.ORDERMSG:
                fragment = new OrderFragment();
                break;
            case InstoreConstantTool.INSTOREMSG_LOC:
                fragment = new LocationInstoreFragment();
                break;
            case InstoreConstantTool.INSTOREMSG_TRAY:
                fragment = new TrayInstoreFragment();
                break;
            case InstoreConstantTool.INSTOREMSG_MATERIALBARCODE:
                fragment = new MaterialBarcodeInstoreFragment();
                break;
        }
        mFragments[curFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    private void setCurChecked(int mCurFragmentIndex) {
           this.mCurFragmentIndex = mCurFragmentIndex;
    }

    private void addAndShowFragment(Fragment fragment) {
        if (fragment.isAdded()) {
            getView().showFragment(fragment);
        } else {
            getView().addFragment(fragment);
        }
    }

    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()) {
            getView().hideFragment(fragment);
        }
    }


}
