package com.zorax.wms.login;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.zorax.wms.R;
import com.zorax.wms.base.BaseActivity;
import com.zorax.wms.base.ViewInject;
import com.zorax.wms.index.IndexActivity;

import butterknife.BindView;

@ViewInject(mainLayoutId = R.layout.activity_login)
public class LoginActivity extends BaseActivity implements ILoginActivityContract.IView{

    @BindView(R.id.login_username_et)
    EditText loginTxUsername;
    @BindView(R.id.login_pwd_et)
    EditText loginTxPassword;
    @BindView(R.id.login_pwd_ib)
    ImageButton loginPwdIb;
    @BindView(R.id.login_btn)
    Button loginBtn;

    private boolean isShowPwd = false;

    @Override
    public void afterBindView() {
        initLisenter();
    }

    private void initLisenter() {
        this.loginPwdIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowPwd) {
                    loginTxPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    loginPwdIb.setBackgroundResource(R.drawable.login_password_left_show);
                } else {
                    loginTxPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    loginPwdIb.setBackgroundResource(R.drawable.login_password_left_hide);
                }
                isShowPwd = !isShowPwd;
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, IndexActivity.class));
                finish();
            }
        });
    }
}
