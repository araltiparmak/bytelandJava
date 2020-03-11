package com.byteland.unification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class ByteLand {

    public int unify(int[] p) {
        int stepCount = 0;
        final Node rootCity = buildByteLand(p);

        while (!rootCity.unificationCompleted()) {
            System.out.println("Step: " + stepCount);
            final List<Integer> unitedCities = new ArrayList<>();

            rootCity.getAllNodes().stream().
                    filter(node -> node.canUnite() && !unitedCities.contains(node.getParent().getId())).
                    forEach(node -> unitedCities.add(node.uniteWithParent()));

            stepCount++;
            System.out.println("---------------");
        }
        System.out.println("--------------Unification Completed!----------------");

        return stepCount;
    }

    private Node buildByteLand(int[] p) {
        int cityCount = p.length + 1;

        // chosen root city does not matter
        final Integer rootCityId = 0;

        final Map<Integer, Node> nodeMap = IntStream.range(0, cityCount)
                .boxed()
                .collect(toMap(Function.identity(), Node::new));

        nodeMap.values()
                .stream()
                .filter(node -> !node.isRoot(rootCityId))
                .forEach(node -> node.setParent(nodeMap.get(p[node.getId() - 1])));

        return nodeMap.get(rootCityId);
    }
}