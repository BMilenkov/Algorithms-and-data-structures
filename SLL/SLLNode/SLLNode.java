package SLL.SLLNode;

public class SLLNode<E> {
    public E data;
    public SLLNode<E> succ;

    public SLLNode(E data, SLLNode<E> succ) {
        this.data = data;
        this.succ = succ;
    }

}

