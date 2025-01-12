package Main.Ejercicio_03_listevels;

import Main.Materia.Controllers.Models.Node;
import java.util.ArrayList;
import java.util.List;

public class Listevels {

    // Método que devuelve una lista de listas de nodos, agrupados por niveles
    public List<List<Node>> Listevels(Node root) {
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
}
