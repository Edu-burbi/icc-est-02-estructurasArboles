package Main.Ejercicio_02_invert;

import Main.Materia.Controllers.Models.Node;

public class InvertBinaryTree {

   private Node root; 

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

    // Método para invertir el árbol
    public void invert() {
        root = invert(root);  // Invertimos el árbol comenzando desde la raíz
    }

    // Método privado para invertir el árbol de manera recursiva
    private Node invert(Node node) {
        if (node == null) {
            return null;  // Si el nodo es null, no hace nada
        }

        // Intercambiamos el subárbol izquierdo y derecho
        Node left = node.getLeft();
        node.setLeft(invert(node.getRight()));
        node.setRight(invert(left));

        return node;
    }

    // Método para imprimir el árbol por niveles
    public void printTree() {
        printTree(root, " ", true);  
    }

    // Método privado para imprimir el árbol de manera jerárquica
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

