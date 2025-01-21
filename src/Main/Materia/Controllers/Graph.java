package Main.Materia.Controllers;

import Main.Materia.Controllers.Models.NodeG;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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

    // Método para agregar una arista unidireccional
    public void addEdgeUni(NodeG src, NodeG dest) {
        src.addNeighbors(dest);
    }

    // Imprimir los nodos y sus vecinos
    public void printGraph() {
        for (NodeG node : nodes) {
            System.out.print("Vertice " + node.getValue() + ": ");
            for (NodeG neighbor : node.getNeighbors()) {
                System.out.print(neighbor.getValue() + " - ");
            }
            System.out.println();
        }
    }

    // DFS (Depth First Search) - Búsqueda en profundidad
    public void getDFS(NodeG startNode) {
        Set<NodeG> visitados = new HashSet<>();
        System.out.println("DFS desde el node " + startNode.getValue() + ":");
        getDFSUtil(startNode, visitados);
    }

    private void getDFSUtil(NodeG node, Set<NodeG> visitados) {
        if (visitados.contains(node)) {
            return;
        }
        System.out.print(node.getValue() + " "); 
        visitados.add(node); 

        for (NodeG neighbor : node.getNeighbors()) {
            getDFSUtil(neighbor, visitados); 
        }
    }

    // BFS (Breadth First Search) - Búsqueda en anchura
    public void getBFS(NodeG startNode) {
        Set<NodeG> visitados = new HashSet<>();
        Queue<NodeG> cola = new LinkedList<>();

        System.out.println("\nBFS desde el nodo " + startNode.getValue());
        cola.add(startNode);
        visitados.add(startNode);

        while (!cola.isEmpty()) {
            NodeG actual = cola.poll();
            System.out.print(actual.getValue() + " "); 

            for (NodeG neighbor : actual.getNeighbors()) {
                if (!visitados.contains(neighbor)) {
                    visitados.add(neighbor);
                    cola.add(neighbor);
                }
            }
        }
        System.out.println(); // Salto de línea después de la ejecución de BFS
    }

    public int[][] getAdjacencyMatrix() {
     
    }

    public void printAdjacencyMatrix() {
     
    }
}
