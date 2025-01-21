import Main.Ejercicio_01_insert.InsertBSTTest;
import Main.Ejercicio_02_invert.InvertBinaryTree;
import Main.Ejercicio_03_listLevels.ListLevels;
import Main.Ejercicio_04_depth.Depth;
import Main.Materia.Controllers.Graph;
import Main.Materia.Controllers.Models.Node;
import Main.Materia.Controllers.Models.NodeG;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //runArboLBinario();
        //runEjercicio1();
        //runEjercicio2();
        //runEjercicio3();
        //runEjercicio4();
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

        NodeG nodo0 = grafo.addNode(0); 
        NodeG nodo1 = grafo.addNode(1); 
        NodeG nodo2 = grafo.addNode(2); 
        NodeG nodo3 = grafo.addNode(3); 
        NodeG nodo4 = grafo.addNode(4);
        NodeG nodo5 = grafo.addNode(5);

        grafo.addEdge(nodo0, nodo3);
        grafo.addEdge(nodo0, nodo5);
        grafo.addEdge(nodo3, nodo2);
        grafo.addEdge(nodo3, nodo4);
        grafo.addEdge(nodo4, nodo1);
        grafo.addEdge(nodo2, nodo1);
        grafo.addEdge(nodo1, nodo0);


        // Imprimir el grafo
        System.out.println("\nGraph Con Edge:");
        grafo.printGraph();


        Graph grafo2 = new Graph();


        NodeG gnodo0 = grafo2.addNode(0); 
        NodeG gnodo1 = grafo2.addNode(1); 
        NodeG gnodo2 = grafo2.addNode(2); 
        NodeG gnodo3 = grafo2.addNode(3); 
        NodeG gnodo4 = grafo2.addNode(4);
        NodeG gnodo5 = grafo2.addNode(5);

        grafo2.addEdgeUni(gnodo0, gnodo3);
        grafo2.addEdgeUni(gnodo0, gnodo5);
        grafo2.addEdgeUni(gnodo3, gnodo2);
        grafo2.addEdgeUni(gnodo3, gnodo4);
        grafo2.addEdgeUni(gnodo4, gnodo1);
        grafo2.addEdgeUni(gnodo2, gnodo1);
        grafo2.addEdgeUni(gnodo1, gnodo0);


        // Imprimir el grafo
        System.out.println("\nGraph Con EdgeUni:");
        grafo2.printGraph();

        System.out.println("\nDireccional");
        grafo2.getDFS(gnodo0);
        grafo2.getBFS(gnodo0);

        System.out.println("\nNo Direccional");
        grafo.getDFS(nodo0);
        grafo.getBFS(nodo0);

    }
}
    

    

