package Main.Ejercicio_04_depth;

import Main.Materia.Controllers.Models.Node;

public class Depth {

    private Node root;  
    // Método para insertar un valor en el árbol binario de búsqueda
    public void insert(int value) {
        root = insert(root, value);  
    }

    // Método privado para insertar en el árbol recursivamente
    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);  
        }
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));  
        } else {
            node.setRight(insert(node.getRight(), value));  
        }
        return node;
    }

    // Método para calcular la profundidad máxima del árbol
    public int maxDepth() {
        return maxDepth(root);
    }

    // Método recursivo para calcular la profundidad máxima
    private int maxDepth(Node node) {
        if (node == null) {
            return 0;  // Si el nodo es null, la profundidad es 0
        }
        int leftDepth = maxDepth(node.getLeft());  // Profundidad del subárbol izquierdo
        int rightDepth = maxDepth(node.getRight());  // Profundidad del subárbol derecho
        return Math.max(leftDepth, rightDepth) + 1;  // Devuelve la profundidad máxima +1
    }

    // Método para imprimir el árbol por niveles
    public void printTree() {
        printTree(root, " ", true);
    }

    // Método privado para imprimir el árbol
    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
            if (node.getLeft() != null || node.getRight() != null) {
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "|   " : "   "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "   ") + "├── null");
                }
                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "|   " : "   "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "   ") + "└── null");
                }
            }
        }
    }
}