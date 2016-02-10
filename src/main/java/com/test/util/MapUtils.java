package com.test.util;

import com.test.model.dungeons.MapModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapUtils {

    public static MapModel gen(int num) {
        List<MapModel> mapNodes = new ArrayList<>();
        List<MapModel> freeNodes = new ArrayList<>();
        Random rand = new Random();

        for (int i=0; i<num; i++) {
            MapModel m = new MapModel();
            mapNodes.add(m);
            freeNodes.add(m);
        }

        MapModel head = freeNodes.remove(0);
        MapModel tail = freeNodes.remove(0);

        while(freeNodes.size() > 0) {
            int numChildren = rand.nextInt(1) + 1;      // random number between 1 and 1
            if (freeNodes.size() < numChildren) {
                numChildren = freeNodes.size();
            }
            List<MapModel> childList = new ArrayList<>();
            for (int i=0; i<numChildren; i++) {
                childList.add(freeNodes.remove(0));
            }

        }

        return head;
    }

}