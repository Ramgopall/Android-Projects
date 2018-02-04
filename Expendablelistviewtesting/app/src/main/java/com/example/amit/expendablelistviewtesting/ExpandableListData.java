package com.example.amit.expendablelistviewtesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Amit on 8/8/2017.
 */

public class ExpandableListData {

    public static HashMap<String,List<String>> getData() {
        HashMap<String,List<String>> expandableListitem = new HashMap<>();

        List<String> cricket = new ArrayList<>();
        cricket.add("India");
        cricket.add("pakistan");
        cricket.add("austrailiya");

        List<String> football = new ArrayList<>();
        football.add("indiaa");
        football.add("Africa");
        football.add("US");

        expandableListitem.put("Cricket Team",cricket);
        expandableListitem.put("Football Team",football);
        return expandableListitem;
    }

}
