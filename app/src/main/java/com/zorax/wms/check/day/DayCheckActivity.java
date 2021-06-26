package com.zorax.wms.check.day;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.timessquare.CalendarPickerView;
import com.zorax.wms.R;
import com.zorax.wms.base.BaseActivity;
import com.zorax.wms.base.ViewInject;
import com.zorax.wms.check.adapter.CheckAdapter;
import com.zorax.wms.check.dto.CheckBeanDataManager;
import com.zorax.wms.tool.DateUtil;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;

@ViewInject(mainLayoutId = R.layout.activity_check_day)
public class DayCheckActivity extends BaseActivity {

    @BindView(R.id.toolbar_ll_tv)
    TextView toolbarLlTv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.check_day_picker_tv)
    TextView checkDayPickerTv;
    @BindView(R.id.check_date_rl)
    RelativeLayout checkDateRl;
    @BindView(R.id.calendar_view)
    CalendarPickerView calendarView;
    @BindView(R.id.check_fl)
    FrameLayout checkFl;
    @BindView(R.id.check_day_recyclerview)
    RecyclerView checkDayRecyclerview;
    @BindView(R.id.check_index_day)
    RadioButton checkIndexDay;
    @BindView(R.id.check_index_total)
    RadioButton checkIndexTotal;

    @Override
    public void afterBindView() {
        initDatePicker();
        initLisenter();
        checkDayRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        checkDayRecyclerview.setAdapter(new CheckAdapter(CheckBeanDataManager.getData()));
    }

    private void initDatePicker() {
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        Date today = new Date();
        calendarView.init(today, nextYear.getTime())
                .withSelectedDate(today);
    }

    private void initLisenter() {
        if (checkFl.getVisibility() == View.VISIBLE)
        {
            checkFl.setVisibility(View.GONE);
        }
        checkDayPickerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkFl.getVisibility() == View.VISIBLE)
                {
                    checkFl.setVisibility(View.GONE);
                }
                else {
                    checkFl.setVisibility(View.VISIBLE);
                }
            }
        });
        calendarView.setCellClickInterceptor(new CalendarPickerView.CellClickInterceptor() {
            @Override
            public boolean onCellClicked(Date date) {
                Date selectedDate = calendarView.getSelectedDate();
                String format = DateUtil.format(selectedDate, DateUtil.DEFAULT_FORMATS);
                checkDayPickerTv.setText(format);
                checkFl.setVisibility(View.GONE);
                return false;
            }
        });
    }
}
