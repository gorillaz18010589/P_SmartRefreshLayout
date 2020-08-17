package com.example.p_smartrefreshlayout;
/*
*
SmartRefreshLayout.finishLoadmoreWithNoMoreData();//没有更多
SmartRefreshLayout.resetNoMoreData()；//恢复没有更多数据的原始状态
SmartRefreshLayout.finishRefresh();//结束刷新
SmartRefreshLayout.finishLoadMore();//结束加载
SmartRefreshLayout.autoRefresh()//自动刷新
SmartRefreshLayout.setEnableFooterFollowWhenLoadFinished（）//设置是否在全部加载结束之后Footer跟随内容
SmartRefreshLayout.setEnableScrollContentWhenLoaded（）//设置是否在加载更多完成之后滚动内容显示新数据
SmartRefreshLayout.setEnableAutoLoadmore（）//设置是否监听列表在滚动到底部时触发加载事件
SmartRefreshLayout.setFooterTriggerRate（）//设置 触发加载距离 与 FooterHieght 的比率
SmartRefreshLayout.setFooterMaxDragRate（）//设置上啦最大高度和Footer高度的比率（将会影响可以上啦的最大高度）
SmartRefreshLayout.setHeaderMaxDragRate（）//设置下拉最大高度和Header高度的比率（将会影响可以下拉的最大高度）*/


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.BezierRadarHeader;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

public class MainActivity extends AppCompatActivity {
    private SmartRefreshLayout smartRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        smartRefresh = findViewById(R.id.smartRefresh);
        smartRefresh.setRefreshHeader(new BezierRadarHeader(this)); //設定刷新樣式
        smartRefresh.setRefreshFooter(new ClassicsFooter(this));
        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        smartRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }
}
