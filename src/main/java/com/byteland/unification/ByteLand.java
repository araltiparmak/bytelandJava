package com.byteland.unification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ByteLand {

    public int unify(int p[]) {
        int step = 0;
        Node rootCity = buildByteLand(p);

        while (!unificationCompleted(rootCity)) {
            System.out.println("Step: " + step);
            List<Integer> unitedCities = new ArrayList<>();

            rootCity.getAllNodes().
                    stream().
                    filter(node -> node.canUnite() && !unitedCities.contains(node.getParent().getId())).
                    forEach(node -> {
                        node.uniteWithParent();
                        unitedCities.add(node.getParent().getId());
                    });
            step++;
            System.out.println("---------------");
        }
        System.out.println("--------------Unification Completed!----------------");
        return step;

    }

    private boolean unificationCompleted(Node rootCity) {
        return rootCity.getAllNodes().size() == 1;
    }

    private Node buildByteLand(int p[]) {
        int cityCount = p.length + 1;

        // chosen root city doesnt matter
        Integer rootCityId = 0;
        Map<Integer, Node> nodeMap = new HashMap<>();

        IntStream.range(0, cityCount).
                forEach(cityId -> nodeMap.put(cityId, new Node(cityId)));

        nodeMap.values().stream().
                filter(node -> !node.getId().equals(rootCityId)).
                forEach(node -> node.setParent(nodeMap.get(p[node.getId() - 1])));

        return nodeMap.get(rootCityId);
    }

}
