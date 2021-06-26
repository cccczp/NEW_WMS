package com.zorax.wms.instore.fragment;

import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zorax.wms.R;
import com.zorax.wms.base.BaseFragment;
import com.zorax.wms.base.ViewInject;
import com.zorax.wms.instore.adapter.InstoreOrderAdapter;
import com.zorax.wms.instore.dto.InstoreOrderBeanDataManager;

import butterknife.BindView;

/**
 * @创作者 czp
 * @创作时间 2021/6/7 14:42
 * @描述
 */
@ViewInject(mainLayoutId = R.layout.instore_order_fragment_public)
public class OrderFragment extends BaseFragment {

    @BindView(R.id.order_recyclerview)
    RecyclerView orderRecyclerview;
    @BindView(R.id.instore_order_fragment_head_asn_tv_demo)
    TextView instoreOrderFragmentHeadAsnTvDemo;
    @BindView(R.id.instore_order_fragment_head_carid_tv_demo)
    TextView instoreOrderFragmentHeadCaridTvDemo;
    @BindView(R.id.instore_order_fragment_head_shipper_tv_demo)
    TextView instoreOrderFragmentHeadShipperTvDemo;
    @BindView(R.id.instore_order_fragment_head_country_tv_demo)
    TextView instoreOrderFragmentHeadCountryTvDemo;
    @BindView(R.id.instore_order_fragment_head_count_tv_demo)
    TextView instoreOrderFragmentHeadCountTvDemo;

    @Override
    public void afterBindView() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        orderRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        orderRecyclerview.setAdapter(new InstoreOrderAdapter(getActivity(), InstoreOrderBeanDataManager.getData()));
    }
}
