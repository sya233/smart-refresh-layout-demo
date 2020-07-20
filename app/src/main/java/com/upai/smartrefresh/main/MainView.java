package com.upai.smartrefresh.main;

import java.util.List;

public interface MainView {

    void showToast(String msg);

    void updateRecyclerView(List<String> list);

    void finishLoad();

    void finishRefresh();

}
