package com.zorax.wms.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.zorax.mvp.IMvpView;
import com.zorax.mvp.base.BaseMvpPresenter;
import com.zorax.task.LfTask;
import com.zorax.task.TaskHelper;
import com.zorax.wms.R;
import com.zorax.wms.check.CheckIndexActivity;
import com.zorax.wms.check.day.DayCheckActivity;
import com.zorax.wms.index.IndexActivity;
import com.zorax.wms.instore.index.InstoreIndexActivity;
import com.zorax.wms.instore.instoreView.InstoreActivity;
import com.zorax.wms.setting.SettingActivity;

/**
 * @创作者 czp
 * @创作时间 2021/6/8 21:09
 * @描述
 */
public abstract class BasePresenter<T extends IMvpView> extends BaseMvpPresenter<T> {

    public BasePresenter(T view) {
        super(view);
    }


    @Override
    public void setText(TextView textView, int index) {
        switch (index) {
            case R.id.instore_index_location:
                textView.setText(R.string.instore_index_location);
                break;
            case R.id.instore_index_tray:
                textView.setText(R.string.instore_index_tray);
                break;
            case R.id.instore_index_materialBarcde:
                textView.setText(R.string.instore_index_materialBarcode);
                break;
            case R.id.index_rb_setting:
                textView.setText(R.string.index_setting);
                break;
            case R.layout.activity_instore_index:
                textView.setText(R.string.instore_index);
                break;
            case R.id.index_rb_check:
                textView.setText(R.string.check_index);
                break;
        }
    }

    @Override
    public void toActivity(Context context, int layout) {
        super.toActivity(context, layout);
        Intent intent = null;
        switch (layout) {
            case R.id.instore_index_location:
            case R.id.instore_index_tray:
            case R.id.instore_index_materialBarcde:
                intent = new Intent(context, InstoreActivity.class);
                context.startActivity(intent);
                break;
            case R.id.index_rb_instore:
            case R.layout.activity_instore_index:
                intent = new Intent(context, InstoreIndexActivity.class);
                context.startActivity(intent);
                break;
            case R.id.index_rb_setting:
                intent = new Intent(context, SettingActivity.class);
                context.startActivity(intent);
                break;
            case R.id.index_rb_check:
                intent = new Intent(context, CheckIndexActivity.class);
                context.startActivity(intent);
                break;
            case R.id.check_index_day:
                intent = new Intent(context, DayCheckActivity.class);
                context.startActivity(intent);
                break;
            case R.layout.activity_index:
                intent = new Intent(context, IndexActivity.class);
                context.startActivity(intent);
                break;
        }
        ((Activity) context).finish();
    }

    public void submit(LfTask lfTask) {
        TaskHelper.submitTask(lfTask, lfTask);
    }

    public void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
