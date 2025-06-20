package materia.controllers;

import java.util.Stack;
import materia.models.Node;

public class BinaryTree {
    private Node root;
    private int peso;
    private Stack<Node> desequilibrados;

    public BinaryTree() {
        this.root = null;
        this.peso = 0;
        this.desequilibrados = new Stack<>();
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            padre = new Node(value);
            peso++;
            return padre;
        }

        if (value <= padre.getNum()) {
            Node newNode = insertRec(padre.getLeft(), value);
            padre.setLeft(newNode);
        } else {
            padre.setRight(insertRec(padre.getRight(), value));
        }

        return padre;
    }

    public void imprimirArbol() {
        imprimirArbolPreRec(root);
    }

    private void imprimirArbolPreRec(Node node) {
        if (node != null) {
            System.out.print(node.getNum() + ", ");
            imprimirArbolPreRec(node.getLeft());
            imprimirArbolPreRec(node.getRight());
        }
    }

    public void imprimirInOrder() {
        imprimirArbolInRec(root);
    }

    private void imprimirArbolInRec(Node node) {
        if (node != null) {
            imprimirArbolInRec(node.getLeft());
            System.out.print(node.getNum() + ", ");
            imprimirArbolInRec(node.getRight());
        }
    }

    public void imprimirPostOrder() {
        imprimirArbolPostRec(root);
    }

    private void imprimirArbolPostRec(Node node) {
        if (node != null) {
            imprimirArbolPostRec(node.getLeft());
            imprimirArbolPostRec(node.getRight());
            System.out.print(node.getNum() + ", ");
        }
    }

    public boolean findeValue(int valor) {
        return findeValueRec(root, valor);
    }

    private boolean findeValueRec(Node node, int valor) {
        if (node == null) {
            return false;
        }
        if (node.getNum() == valor) {
            return true;
        }
        if (node.getNum() < valor) {
            return findeValueRec(node.getRight(), valor);
        } else {
            return findeValueRec(node.getLeft(), valor);
        }
    }

    public int getHeightTree() {
        return getHeightTreeRec(root);
    }

    private int getHeightTreeRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightTreeRec(node.getLeft());
        int rightHeight = getHeightTreeRec(node.getRight());

        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }

    public void imprimirInOrderAltura() {
        imprimirArbolInRecAltura(root);
    }

    private void imprimirArbolInRecAltura(Node node) {
        if (node != null) {
            imprimirArbolInRecAltura(node.getLeft());
            int height = getHeightTreeRec(node);
            System.out.print(node.getNum() + "(h =" + height + "), ");
            imprimirArbolInRecAltura(node.getRight());
        }
    }

    public void imprimirInOrderConBalanceFactor() {
        desequilibrados.clear(); // Reinicia la pila
        imprimirInOrderConBalanceFactorRec(root);
    }

    private void imprimirInOrderConBalanceFactorRec(Node node) {
        if (node != null) {
            imprimirInOrderConBalanceFactorRec(node.getLeft());
            int balance = getBalanceFactorRec(node);
            if (balance < -1 || balance > 1) {
                desequilibrados.push(node);
            }
            System.out.print(node.getNum() + "(bf= " + balance + "), ");
            imprimirInOrderConBalanceFactorRec(node.getRight());
        }
    }

    private int getBalanceFactorRec(Node node) {
        if (node == null) {
            return 0;
        }

        return getHeightTreeRec(node.getLeft()) - getHeightTreeRec(node.getRight());
    }

    public boolean estaEquilibrado() {
        desequilibrados.clear();
        return desequilibrados.isEmpty();
    }

    public int getPeso() {
        return peso;
    }
}
