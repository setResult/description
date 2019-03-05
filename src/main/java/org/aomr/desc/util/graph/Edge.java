package org.aomr.desc.util.graph;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.aomr.desc.util.graph
 * Author:      aomr
 * Date:        2019/3/5 下午5:32
 * Description: 一条边
 */
public class Edge<V> {
    /**起点*/
    private V src;
    /**终点*/
    private V dest;
    /**权值*/
    private double weight;

    /**
     * 不带权值的一条边
     * @param src
     * @param dest
     */
    public Edge(V src, V dest) {
        this(src, dest, 0);
    }

    /**
     * 带权值的一条边
     * @param src
     * @param dest
     * @param weight
     */
    public Edge(V src, V dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    /**
     * 获取起点
     * @return
     */
    public V getSource() {
        return this.src;
    }

    /**
     * 获取终点
     * @return
     */
    public V getDest() {
        return this.dest;
    }

    /**
     * 获取权值
     * @return
     */
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        String ret = String.format("src : %s , dest : %s , weight : %s", src, dest, weight);
        return ret;
    }
}
