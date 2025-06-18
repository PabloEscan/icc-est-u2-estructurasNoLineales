package materia.models;

public class Node {
    private int num;
    private Node Left;
    private Node Right;
    
    public Node(int num) {
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setLeft(Node left) {
        Left = left;
    }

    public void setRight(Node right) {
        Right = right;
    }

    public int getNum() {
        return num;
    }

    public Node getLeft() {
        return Left;
    }

    public Node getRight() {
        return Right;
    }

    @Override
    public String toString() {
        return "Node [num=" + num + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + num;
        result = prime * result + ((Left == null) ? 0 : Left.hashCode());
        result = prime * result + ((Right == null) ? 0 : Right.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (num != other.num)
            return false;
        if (Left == null) {
            if (other.Left != null)
                return false;
        } else if (!Left.equals(other.Left))
            return false;
        if (Right == null) {
            if (other.Right != null)
                return false;
        } else if (!Right.equals(other.Right))
            return false;
        return true;
    }

    
}
