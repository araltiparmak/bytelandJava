package com.byteland.unification;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Integer id;
    private Node parent;
    private String name;
    private List<Node> childNodes = new ArrayList<>();

    public Node(int value) {
        this.id = value;
        this.name = String.valueOf(value);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    public Integer getId() {
        return id;
    }

    public void addChild(Node node) {
        childNodes.add(node);
    }

    private void removeChild(Node node) {
        childNodes.remove(node);
    }

    private List<Node> getChildNodes() {
        return childNodes;
    }

    public List<Node> getAllNodes() {
        List<Node> allNodes = new ArrayList<>();
        addAllNodes(allNodes, this);
        return allNodes;
    }

    private void addAllNodes(List<Node> allNodes, Node rootNode) {
        allNodes.add(rootNode);
        rootNode.getChildNodes().forEach(node -> addAllNodes(allNodes, node));
    }

    public void uniteWithParent() {
        System.out.println(name + " is merging with " + parent.name);
        getChildNodes().forEach(n -> n.setParent(parent));
        parent.removeChild(this);
        parent.name += "_" + name;
    }

    public boolean hasLeafChild() {
        return childNodes.stream().anyMatch(Node::isLeaf);
    }

    private boolean isLeaf() {
        return childNodes.size() == 0;
    }

     boolean canUnite() {
        return getParent() != null && !hasLeafChild();
    }
}
