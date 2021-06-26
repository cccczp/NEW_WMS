package com.zorax.mvp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zorax.mvp.IMvpView;
import com.zorax.mvp.MvpControler;

/**
 * @创作者 czp
 * @创作时间 2021/5/28 20:21
 * @描述
 */
public class LifeCircleMvpActivity extends AppCompatActivity implements IMvpView {
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if (intent == null)
        {
            intent = new Intent();
        }
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onCreate(savedInstanceState,intent,null);
            controler.onActivityCreate(savedInstanceState,intent,null);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onNewIntent(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onDestroy();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpControler controler = this.mvpControler;
        if (controler != null)
        {
            controler.onSaveInstanceState(outState);
        }
    }
}
