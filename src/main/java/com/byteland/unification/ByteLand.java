package com.byteland.unification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ByteLand {

    public int unify(int cityCount, int p[]) {
        int step = 0;
        Node rootCity = buildByteLand(cityCount, p);
        while (rootCity.getAllNodes().size() != 1) {
            List<Integer> blackList = new ArrayList<>();

            rootCity.getAllNodes().
                    stream().
                    filter(node -> canUnite(blackList, node)).
                    forEach(node -> {
                        node.unionWithParent();
                        blackList.add(node.getParent().getId());
                    });
            step++;
        }
        return step;
    }

    private boolean canUnite(List<Integer> blackList, Node node) {
        return node.getParent() != null && !blackList.contains(node.getParent().getId()) && !node.hasLeafChild();
    }

    private Node buildByteLand(int cityCount, int p[]) {
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
