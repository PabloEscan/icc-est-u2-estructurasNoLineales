import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree ab = new BinaryTree();        
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        System.out.println("Peso del arbol= " + ab.getPeso());
        System.out.println("Altura es = " + ab.getHeightTree() +"\n");
        
        System.out.println("Arbol InOrder");
        ab.imprimirInOrder();

        System.out.println("\n\nArbol InOrder con alturas");
        ab.imprimirInOrderAltura();

        System.out.println("\n\nArbol InOrder con factor de equilibrio");
        ab.imprimirInOrderConBalanceFactor();

        System.out.println("\n\nArbol esta equilibrado = " + ab.estaEquilibrado());

        int valorNodo = 15;
        System.out.println("Existe el nodo " + valorNodo + " = " + ab.findeValue(valorNodo));
        System.out.println("Agregamos el valor = " + valorNodo);
        ab.insert(valorNodo);
        System.out.println("Arbol esta equilibrado = " + ab.estaEquilibrado());

        
    }
}
