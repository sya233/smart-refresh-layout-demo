package com.upai.smartrefresh.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainModel {

    private List<String> stringList = new ArrayList<>();

    List<String> initRecyclerView(){
        stringList.clear();
        for (int i = 0; i < 30; i++) {
            int num = new Random().nextInt(200);
            String s = String.valueOf(num);
            stringList.add(s);
        }
        return stringList;
    }

    List<String> updateRecyclerView() {
        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(100);
            String s = String.valueOf(num);
            stringList.add(s);
        }
        return stringList;
    }

}
