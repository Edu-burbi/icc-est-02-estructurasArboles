import Main.Materia.Controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        runArboLBinario();
    }

    public static void runArboLBinario() {
        ArbolBinario arbolBinario = new ArbolBinario();

        int[] valores = {0, 20, 60, 10, 30, 50, 70, 5, 15, 55};
        for (int value : valores) {
            arbolBinario.insert(value);
        }
        arbolBinario.printTree();
    }
}
