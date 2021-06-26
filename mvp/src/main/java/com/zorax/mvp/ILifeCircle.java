package com.zorax.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @创作者 czp
 * @创作时间 2021/5/28 19:49
 * @描述
 */
public interface ILifeCircle {
    void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onActivityCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void destroyView();

    void onDestroy();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView mvpView);

    void toActivity(Context context, int layout);

    void setText(TextView textView, int index);

    void showToast(Context context,String msg);

}
