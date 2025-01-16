package Main.Ejercicio_03_listLevels;

import Main.Materia.Controllers.Models.Node;
import java.util.ArrayList;
import java.util.List;

public class ListLevels {

    private Node root = null;  // Nodo raíz

    // Método para insertar un valor en el árbol binario
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

    // Método que devuelve una lista de listas de nodos, agrupados por niveles
    public List<List<Node>> ListLevels(Node root) {
        List<List<Node>> levels = new ArrayList<>();  // Lista que contendrá los nodos por niveles

        if (root == null) {
            return levels;  // Si el árbol está vacío, retornamos una lista vacía
        }

        List<Node> currentLevel = new ArrayList<>();  // Lista temporal para los nodos del nivel actual
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            levels.add(currentLevel);  // Agregamos el nivel actual a la lista de niveles

            List<Node> nextLevel = new ArrayList<>();  // Lista para el siguiente nivel

            // Procesamos todos los nodos del nivel actual
            for (Node node : currentLevel) {
                if (node.getLeft() != null) {  // Usamos getLeft en lugar de acceder directamente a left
                    nextLevel.add(node.getLeft());
                }
                if (node.getRight() != null) {  // Usamos getRight en lugar de acceder directamente a right
                    nextLevel.add(node.getRight());
                }
            }

            currentLevel = nextLevel;  // Avanzamos al siguiente nivel
        }

        return levels;  // Devolvemos la lista de niveles
    }

    public Node getRoot() {
        return root;
    }

    // Método para imprimir el árbol por niveles
    public void printTree() {
        printTree(root, " ", true);  // Llama al método recursivo para imprimir el árbol
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