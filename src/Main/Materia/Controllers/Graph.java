package Main.Materia.Controllers;

import Main.Materia.Controllers.Models.NodeG;
import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<NodeG> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    // Método para agregar un nodo al grafo
    public NodeG addNode(int value) {
        NodeG nodeG = new NodeG(value); 
        nodes.add(nodeG);
        return nodeG;
    }

    // Método para agregar una arista entre dos nodos
    public void addEdge(NodeG src, NodeG dest) {
        src.addNeighbors(dest);  
        dest.addNeighbors(src);  
    }

    // Imprimir los nodos y sus vecinos
    public void printGraph() {
        for (NodeG node : nodes) {
            System.out.print("Node " + node.getValue() + ": ");
            for (NodeG neighbor : node.getNeighbors()) {
                System.out.print(neighbor.getValue() + " ");
            }
            System.out.println();
        }
    }

    public void getDFS(NodeG startNode) {
       
    }

    public void getDFSUtil(NodeG node, boolean[] visited) {
       
    }

    public void getBFS(NodeG startNode) {
      
    }

    public int[][] getAdjacencyMatrix() {

    }

    public void printAdjacencyMatrix() {
        
    }
}
