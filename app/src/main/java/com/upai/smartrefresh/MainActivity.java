package com.upai.smartrefresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.upai.smartrefresh.adapter.MainAdapter;
import com.upai.smartrefresh.main.MainModel;
import com.upai.smartrefresh.main.MainPresenter;
import com.upai.smartrefresh.main.MainView;
import com.upai.smartrefresh.util.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter mainPresenter;

    // RecyclerView
    private RecyclerView rvMain;
    private MainAdapter mainAdapter;
    // SmartRefreshLayout
    private SmartRefreshLayout srlMain;

    @Override
    protected int onCreate() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        // 控件id
        Toolbar toolbar = findViewById(R.id.toolbar);
        rvMain=findViewById(R.id.rv_main);
        srlMain=findViewById(R.id.srl_main);
        // 初始化Presenter
        mainPresenter=new MainPresenter(this,new MainModel());
        // 设置ActionBar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("主界面");
        }
        // 设置RecyclerView
        LinearLayoutManager layoutManager=new LinearLayoutManager(rvMain.getContext());
        rvMain.setLayoutManager(layoutManager);
        mainAdapter=new MainAdapter();
        mainPresenter.initRecyclerView();
        rvMain.setAdapter(mainAdapter);
        // 上拉刷新和下拉加载
        respondToRefresh();
    }

    private void respondToRefresh(){
        srlMain.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mainPresenter.refreshRecyclerView();
            }
        });
        srlMain.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mainPresenter.loadMoreRecyclerView();
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateRecyclerView(List<String> list) {
        mainAdapter.updateList(list);
    }

    @Override
    public void finishLoad() {
        srlMain.finishLoadMore();
    }

    @Override
    public void finishRefresh() {
        srlMain.finishRefresh();
    }
}
