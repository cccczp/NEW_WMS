package com.zorax.mvp.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.zorax.R;
import com.zorax.mvp.ILifeCircle;
import com.zorax.mvp.IMvpView;
import com.zorax.mvp.MvpControler;

import java.lang.ref.WeakReference;

/**
 * @创作者 czp
 * @创作时间 2021/5/28 19:54
 * @描述
 */
public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {
    private WeakReference<T> mWeakReference;

    private TextView mTextView;

    protected LifeCircleMvpPresenter() {
        super();
    }

    public LifeCircleMvpPresenter(IMvpView mvpView) {
        super();
        attachView(mvpView);
        MvpControler mvpControler = mvpView.getMvpControler();
        if (mvpControler != null) {
            mvpControler.savePresenter(this);
        }
    }

    @Override
    public void attachView(IMvpView mvpView) {
        if (mWeakReference == null) {
            mWeakReference = new WeakReference(mvpView);
        } else {
            T view = (T) mWeakReference.get();
            if (view != mvpView) {
                mWeakReference = new WeakReference(mvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        mWeakReference = null;
    }

    protected T getView() {
        T view = mWeakReference != null ? mWeakReference.get() : null;
        if (view == null) {
            getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();

    @Override
    public void toActivity(Context context, int layout) {
    }

}
