package dataStructure;

import java.util.ArrayList;

/**
 * Created by liyanzhen on 16/12/4.
 * 邻接矩阵：adjacency matrix
 */

public class AMGraph {
    private ArrayList vertexList;//存储点的列表
    private int[][] edges;//存储边
    private int numOfEdges;//边的数目

    public AMGraph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }


    public int getNumOfEdges() {
        return numOfEdges;
    }

    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(), vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        if (weight != 0) {
            numOfEdges++;
        }
    }

    public void deleteEdges(int v1, int v2) {
        edges[v1][v2] = 0;
        numOfEdges--;
    }

    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j > vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    public static void main(String args[]) {
        AMGraph am = new AMGraph(3);
        am.insertVertex(1);
        am.insertVertex(2);
        am.insertVertex(3);

        am.insertEdge(0, 0, 0);
        am.insertEdge(0, 1, 1);
        am.insertEdge(0, 2, 0);
        am.insertEdge(1, 0, 1);
        am.insertEdge(1, 1, 0);
        am.insertEdge(1, 2, 1);
        am.insertEdge(2, 0, 0);
        am.insertEdge(2, 1, 1);
        am.insertEdge(2, 2, 0);
        System.out.println(am.getNumOfVertex());
        System.out.println(am.numOfEdges);
    }
}
