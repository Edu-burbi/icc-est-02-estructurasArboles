package Main.Materia.Controllers.Models;

import java.util.LinkedList;
import java.util.List;

public class NodeG {

    private int value;
    private List<NodeG> neighbors;

    // Constructor con un parámetro 'value' de tipo int
    public NodeG(int value) {
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    // Getter para el valor del nodo
    public int getValue() {
        return value;
    }

    // Getter para la lista de vecinos
    public List<NodeG> getNeighbors() {
        return neighbors;
    }

    // Método para añadir un vecino
    public void addNeighbors(NodeG neighbor) {
        this.neighbors.add(neighbor);
    }
}
