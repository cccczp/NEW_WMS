package com.zorax.wms.login;


import com.zorax.mvp.base.BaseMvpPresenter;
import com.zorax.wms.base.BasePresenter;

/**
 * @创作者 czp
 * @创作时间 2021/5/29 16:16
 * @描述
 */
public class LoginActivityPresenter extends BasePresenter<ILoginActivityContract.IView> implements ILoginActivityContract.IPresenter{

    public LoginActivityPresenter(ILoginActivityContract.IView view) {
        super(view);
    }

    @Override
    protected ILoginActivityContract.IView getEmptyView() {
        return null;
    }

}
