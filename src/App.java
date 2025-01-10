import Main.Materia.Controllers.ArbolBinario;
import Main.Materia.Controllers.ArbolRecorrido;

public class App {
    public static void main(String[] args) throws Exception {
        runArboLBinario();
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
}
