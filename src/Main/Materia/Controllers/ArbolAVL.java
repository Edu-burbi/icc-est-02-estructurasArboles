package Main.Materia.Controllers;

import Main.Materia.Controllers.Models.Node;

public class ArbolAVL {
    private Node root;

    public void insert(int value){
        System.out.println("\nNodo a insertar: " + value);
        root = insert(root, value);
        // Imprimir el árbol después de cada inserción
        printTree();
    }

    private Node insert(Node node, int value){
        if (node == null){
            Node newNode = new Node(value);
            newNode.setHeight(1);
            return newNode;
        }

        if(value < node.getValue()){
            node.setLeft(insert(node.getLeft(), value));

        }else if(value > node.getValue()){
            node.setRight(insert(node.getRight(), value));

        }else {
            return node;  // No insertamos valores duplicados
        }

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        // Obtener el balance o factor de equilibrio del nodo
        int balance = getBalance(node);

        // CASO IZQUIERDA - IZQUIERDA
        if(balance > 1 && value < node.getLeft().getValue()){
            node = rightRotate(node);
        }

        // CASO DERECHA - DERECHA
        if(balance < -1 && value > node.getRight().getValue()){
            node = leftRotate(node);
        }

        // CASO IZQUIERDA - DERECHA
        if(balance > 1 && value > node.getLeft().getValue()){
            node.setLeft(leftRotate(node.getLeft()));
            node = rightRotate(node);
        }

        // CASO DERECHA - IZQUIERDA
        if(balance < -1 && value < node.getRight().getValue()){
            node.setRight(rightRotate(node.getRight()));
            node = leftRotate(node);
        }

        // Devolvemos el nodo
        return node;
    }

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

    private Node leftRotate(Node x){
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

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public void printTree() {
        printTree(root, " ", true);
    }

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

    private void printNodeInfo(Node node) {
        printNodeInfo(node, 0);
    }

    private void printNodeInfo(Node node, int level) {
        if (node != null) {
        int balance = getBalance(node);
        System.out.println("Nodo: " + node.getValue() + 
                           ", Altura: " + node.getHeight() + 
                           ", Balance: " + balance + 
                           ", Nivel: " + level);
        // Llamar recursivamente para el hijo izquierdo y derecho
        printNodeInfo(node.getLeft(), level + 1);
        printNodeInfo(node.getRight(), level + 1);
    }
}
}