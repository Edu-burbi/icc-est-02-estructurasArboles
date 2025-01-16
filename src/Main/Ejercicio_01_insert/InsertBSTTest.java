package Main.Ejercicio_01_insert;

import java.util.ArrayList;
import java.util.List;
import Main.Materia.Controllers.Models.Node;

public class InsertBSTTest {

    private Node root;  
    private List<Integer> insertionOrder = new ArrayList<>();  // Lista para almacenar el orden de inserción

    // Método para insertar un valor en el árbol binario de búsqueda
    public void insert(int value) {
        root = insert(root, value);  
        insertionOrder.add(value);   
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

    public void printInsertionOrder() {
        System.out.print("\nNúmeros insertados: {");
        for (int i = 0; i < insertionOrder.size(); i++) {
            if (i > 0) {
                System.out.print(", ");  // Coma entre los números
            }
            System.out.print(insertionOrder.get(i));  // Imprimir cada valor
        }
        System.out.println("}");
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