package com.upai.smartrefresh.main;

import java.util.List;

public class MainPresenter {

    private MainView mainView;
    private MainModel mainModel;

    public MainPresenter(MainView view, MainModel model) {
        mainView = view;
        mainModel = model;
    }

    public void initRecyclerView(){
        List<String> list=mainModel.initRecyclerView();
        mainView.updateRecyclerView(list);
    }

    public void refreshRecyclerView(){
        List<String> list=mainModel.initRecyclerView();
        mainView.updateRecyclerView(list);
        mainView.finishRefresh();
    }

    public void loadMoreRecyclerView(){
        List<String> list=mainModel.updateRecyclerView();
        mainView.updateRecyclerView(list);
        mainView.finishLoad();
    }

}
