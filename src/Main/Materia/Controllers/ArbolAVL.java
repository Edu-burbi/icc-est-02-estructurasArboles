package Main.Materia.Controllers;

import Main.Materia.Controllers.Models.Node;

public class ArbolAVL {
    private Node root;

    // Método de inserción
    public void insert(int value) {
        System.out.println("\nNodo a insertar: " + value);
        root = insert(root, value);
        // Imprimir el árbol después de cada inserción
        System.out.println("\nNodo insetado: " + value);
        printTree();    
    }

    // Método recursivo para insertar un valor en el árbol
    private Node insert(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            return newNode;
        }

        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));

        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));

        } else {
            return node;  // No insertamos valores duplicados
        }

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        // Obtener el balance o factor de equilibrio del nodo
        int balance = getBalance(node);

        // Rotaciones según el balance
        if (balance > 1 && value < node.getLeft().getValue()) {
            node = rightRotate(node);
        }
        if (balance < -1 && value > node.getRight().getValue()) {
            node = leftRotate(node);
        }
        if (balance > 1 && value > node.getLeft().getValue()) {
            node.setLeft(leftRotate(node.getLeft()));
            node = rightRotate(node);
        }
        if (balance < -1 && value < node.getRight().getValue()) {
            node.setRight(rightRotate(node.getRight()));
            node = leftRotate(node);
        }

        return node;
    }

    // Rotación a la derecha
    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("\nRotamos derecha al nodo: " + y.getValue());

        // Realizamos la rotación
        x.setRight(y);
        y.setLeft(temp);

        // Actualizamos las alturas
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        // Imprimir el árbol después de la rotación
        printTree();

        return x;
    }

    // Rotación a la izquierda
    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();

        System.out.println("\nRotamos izquierda al nodo: " + x.getValue());

        // Realizamos la rotación
        y.setLeft(x);
        x.setRight(temp);

        // Actualizamos las alturas
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        // Imprimir el árbol después de la rotación
        printTree();

        return y;
    }

    // Método para calcular la altura de un nodo
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    // Método para calcular el balance de un nodo
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    // Imprimir el árbol con información adicional
    public void printTree() {
        printTree(root, " ", true, 0);
    }

    // Método recursivo para imprimir el árbol con altura, balance y nivel
    private void printTree(Node node, String prefix, boolean isLeft, int level) {
        if (node != null) {
            int balance = getBalance(node);
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue() +
                    " [Altura: " + node.getHeight() + ", Balance: " + balance + ", Nivel: " + level + "]");
            if (node.getLeft() != null || node.getRight() != null) {
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "|   " : "   "), true, level + 1);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "   ") + "├── null");
                }
                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "|   " : "   "), false, level + 1);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "   ") + "└── null");
                }
            }
        }
    }
}
