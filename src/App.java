import Main.Ejercicio_03_listevels.Listevels;
import Main.Materia.Controllers.ArbolBinario;
import Main.Materia.Controllers.ArbolRecorrido;
import Main.Materia.Controllers.Models.Node;  
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        runArboLBinario();
        runEjercicio();
    }

    public static void runArboLBinario() {
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

     private static void runEjercicio() {

        ArbolBinario arbolbinario = new ArbolBinario();
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        for (int valor : valores) {
            arbolbinario.insert(valor);
        }

        System.out.println("\nÁrbol binario:");
        arbolbinario.printTree();


        Listevels levels = new Listevels();
        List<List<Node>> result = levels.Listevels(arbolbinario.getRoot());

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
 }