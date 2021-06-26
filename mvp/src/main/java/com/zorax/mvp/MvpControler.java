package com.zorax.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @创作者 czp
 * @创作时间 2021/5/28 20:23
 * @描述
 */
public class MvpControler  implements ILifeCircle {
    Set<ILifeCircle> mSet = new HashSet<>();

    public static MvpControler newInstance() {
        return new MvpControler();
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            if (intent == null)
            {
                intent = new Intent();
            }
            if (getArguments == null)
            {
                getArguments = new Bundle();
            }
            next.onCreate(savedInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onActivityCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            if (intent == null)
            {
                intent = new Intent();
            }
            if (getArguments == null)
            {
                getArguments = new Bundle();
            }
            next.onActivityCreate(savedInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.onResume();
        }
    }

    @Override
    public void onPause() {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.onStop();
        }
    }

    @Override
    public void destroyView() {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.destroyView();
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.onDestroy();
        }
    }

    @Override
    public void onViewDestroy() {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            if (intent == null)
            {
                intent = new Intent();
            }
            next.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attachView(IMvpView mvpView) {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.attachView(mvpView);
        }
    }

    @Override
    public void toActivity(Context context, int layout) {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.toActivity(context,layout);
        }
    }

    @Override
    public void setText(TextView textView, int index) {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.setText(textView,index);
        }
    }

    @Override
    public void showToast(Context context, String msg) {
        Iterator<ILifeCircle> iterator = mSet.iterator();
        while (iterator.hasNext())
        {
            ILifeCircle next = iterator.next();
            next.showToast(context,msg);
        }
    }

    public void savePresenter(ILifeCircle lifeCircle) {
        if (lifeCircle != null)
        {
            mSet.add(lifeCircle);
        }
    }


}
