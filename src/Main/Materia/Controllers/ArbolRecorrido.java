package Main.Materia.Controllers;

import Main.Materia.Controllers.Models.Node;
import java.util.Stack;

public class ArbolRecorrido {

    public void preorderIterativo(Node root){
        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.getValue() + " ");


            if(node.getRight() != null){
                stack.push(node.getRight());
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft());
                
            }
        }
    }
}
