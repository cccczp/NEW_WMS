package com.zorax.mvp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zorax.mvp.IMvpView;
import com.zorax.mvp.MvpControler;


/**
 * @创作者 czp
 * @创作时间 2021/5/28 20:21
 * @描述
 */
public class LifeCircleMvpFragment extends Fragment implements IMvpView {
    private MvpControler mvpControler;

    @Override
    public MvpControler getMvpControler() {
        if (this.mvpControler == null)
        {
            this.mvpControler = new MvpControler();
        }
        return this.mvpControler;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onCreate(savedInstanceState, null,bundle);
            controler.onActivityCreate(savedInstanceState,null,bundle);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onActivityCreate(savedInstanceState,null,bundle);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onViewDestroy();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onSaveInstanceState(outState);
        }
    }
}
