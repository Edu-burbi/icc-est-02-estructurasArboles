import Main.Ejercicio_01_insert.InsertBSTTest;
import Main.Ejercicio_02_invert.InvertBinaryTree;
import Main.Ejercicio_03_listLevels.ListLevels;
import Main.Ejercicio_04_depth.Depth;
import Main.Materia.Controllers.Graph;
import Main.Materia.Controllers.Models.Node;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //runArboLBinario();
        runEjercicio1();
        runEjercicio2();
        runEjercicio3();
        runEjercicio4();
        runGraph();
        //runArbolAVL();
    }

    /*public static void runArboLBinario() {
        ArbolBinario arbolBinario = new ArbolBinario();

        int[] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};
        for (int value : valores) {
            arbolBinario.insert(value);
        }
        arbolBinario.printTree();


        ArbolRecorrido arbolRecorrido = new ArbolRecorrido();

        System.out.println("\nRecorrido PreOrden Interativo: ");
        arbolRecorrido.preOrderInterativo(arbolBinario.getRoot());

        System.out.println("\nRecorrido Preorden Recursivo: ");
        arbolRecorrido.preOrderRecursivo(arbolBinario.getRoot());

        System.out.println("\nRecorrido inOrder Recursivo: ");
        arbolRecorrido.inOrderRecursivo(arbolBinario.getRoot());

        System.out.println("\nRecorrido PostOrder Recursivo: ");
        arbolRecorrido.postOrderRecursivo(arbolBinario.getRoot());

    }

    private static void runArbolAVL() {
        System.out.println("\nArbol avl");
        int [] values = {10,9,8,20,15,24,21,23,50,25};   
        ArbolAVL arbolavl = new ArbolAVL();
            for(int num : values){
                arbolavl.insert(num);
            }

        arbolavl.printTree();
    }
*/
    private static void runEjercicio1() {

        System.out.println("\nEjercicio 1");
        InsertBSTTest insertBSTTest = new InsertBSTTest();

        int[] valores = {5, 3, 7, 2, 4, 6, 8};
        for (int valor : valores) {
            insertBSTTest.insert(valor);  
        }

        insertBSTTest.printInsertionOrder();  // Imprimir los valores en el orden en que fueron insertados
    
        // Imprimir el árbol 
        System.out.println("\nÁrbol Ejercicio:");
        insertBSTTest.printTree();  // Imprimir el árbol por niveles
    }


    private static void runEjercicio2() {

        System.out.println("\nEjercicio 2");
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        for (int valor : valores) {
            invertBinaryTree.insert(valor);
        }

        // Imprimir árbol original
        System.out.println("\nÁrbol original:");
        invertBinaryTree.printTree();

        // Invertir el árbol
        invertBinaryTree.invert();

        // Imprimir árbol invertido
        System.out.println("\nÁrbol invertido:");
        invertBinaryTree.printTree();
    }

    private static void runEjercicio3() {

        System.out.println("\nEjercicio 3");
        ListLevels levels = new ListLevels();
        
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        for (int valor : valores) {
            levels.insert(valor);
        }

        System.out.println("\nÁrbol Ejercicio:");
        levels.printTree();
        
        List<List<Node>> result = levels.ListLevels(levels.getRoot());

        System.out.println("\nNiveles del árbol:");
        for (int i = 0; i < result.size(); i++) {
            List<Node> level = result.get(i);
            System.out.print("Nivel " + i + ": ");
            for (Node node : level) {
                System.out.print(node.getValue() + " ");
            }
            System.out.println();
        }
    }

    private static void runEjercicio4() {

        System.out.println("\nEjercicio 4");
        Depth depth = new Depth();

        int[] valores = {4, 2, 7, 1, 3, 8};
        for (int valor : valores) {
            depth.insert(valor);
        }

        // Imprimir árbol
        System.out.println("\nÁrbol binario:");
        depth.printTree();

        // Calcular y mostrar la profundidad máxima
        System.out.println("\nProfundidad máxima del árbol: " + depth.maxDepth());
        System.out.println("\n");

        // error en el pdf la profundidad dice 4 pero en realidad es 3
    }

    private static void runGraph() {

        Graph grafo = new Graph();

        // Agregar nodos al grafo
        grafo.addNode(5); 
        grafo.addNode(7); 
        grafo.addNode(9); 
        grafo.addNode(11); 
        grafo.addNode(3); 

        // Imprimir el grafo
        System.out.println("Graph:");
        grafo.printGraph();

    }
}
    

    

