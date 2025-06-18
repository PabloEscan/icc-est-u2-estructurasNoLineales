package materia.controllers;

import materia.models.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value){
        root = insertRec(root, value);

    }

    private Node insertRec(Node padre, int value){
        if(padre == null){
            padre = new Node(value);
            return padre;
        }

        if(value <= padre.getNum()){
            //Me voy a la Izquierda
            Node newNode = insertRec(padre.getLeft(), value);
            padre.setLeft(newNode);
        }else if(value > padre.getNum()){
            //Me voy a la derecha
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
}
