package Main.Materia.Controllers;

import Main.Materia.Controllers.Models.Node;
import java.util.Stack;

public class ArbolRecorrido {

    public void preOrderInterativo(Node root){

    // Veriifica si el node esta vacio 

        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.getValue() + ", ");

            // Primero se apila el hijo derecho
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            // Después se apila el hijo izquierdo
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }
    public void preOrderRecursivo(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            preOrderRecursivo(node.getLeft());  // Recorrido a la izquierda
            preOrderRecursivo(node.getRight()); // Recorrido a la derecha
        }
    }

    // Recorrido Inorden Recursivo
    public void inOrderRecursivo(Node node) {
        if (node != null) {
            inOrderRecursivo(node.getLeft()); // Recorrido a la izquierda
            System.out.print(node.getValue() + ", ");  // Imprimir el valor
            inOrderRecursivo(node.getRight()); // Recorrido a la derecha
        }
    }

    // Recorrido Postorden Recursivo
    public void postOrderRecursivo(Node node) {
        if (node != null) {
            postOrderRecursivo(node.getLeft()); // Recorrido a la izquierda
            postOrderRecursivo(node.getRight()); // Recorrido a la derecha
            System.out.print(node.getValue() + ", "); // Imprimir el valor
        }
    }
}