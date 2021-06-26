package com.zorax.wms.base;

import android.os.Bundle;


import com.zorax.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayoutId = annotation.mainLayoutId();
            if (mainLayoutId > 0) {
                setContentView(mainLayoutId);
                bindView();

                afterBindView();
            } else {
                throw new RuntimeException("mainLayoutId < 0");
            }
        } else {
            throw new RuntimeException("annotation = null");
        }
    }

    // 模板方法 设计模式
    public abstract void afterBindView();

    // View 的依赖注入绑定
    private void bindView() {
        ButterKnife.bind(this);
    }

}
