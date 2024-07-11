package SLL.SLLNode;

public class MySLL<E> {
    SLLNode<E> first;

    public MySLL() {
        this.first = null;
    }

    public SLLNode<E> getFirst() {
        return first;
    }


    public void mirror() {
        if (first != null) {
            SLLNode<E> curr = first;
            SLLNode<E> prev = null;
            SLLNode<E> next;

            while (curr != null) {
                next = curr.succ;
                curr.succ = prev;
                prev = curr;
                curr = next;
            }
            first = prev;
        }
    }

    public void setFirst(SLLNode<E> node) {
        first = node;
    }

    public int getSize() {
        SLLNode<E> temp = getFirst();
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.succ;
        }
        return counter;
    }

    @Override
    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret += tmp.data;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += "->" + tmp.data;
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
        StringBuilder stringBuilder = new StringBuilder();
        if (first != null) {
            SLLNode<E> temp = first;
            stringBuilder.append(temp.data);
            temp = temp.succ;
            while (temp != null) {
                stringBuilder.append("->" + temp.data);
                temp = temp.succ;
            }
        } else {
            stringBuilder.append("Listata e prazna!!!");
        }
        return stringBuilder.toString();
    }


    public void insertFirst(E o) {
        SLLNode<E> newNode = new SLLNode<>(o, null);
        newNode.succ = first;
        first = newNode;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> newNode = new SLLNode<>(o, node.succ);
            node.succ = newNode;
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {
        if (first != null) {
            SLLNode<E> temp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            while (temp.succ != before && temp.succ != null)
                temp = temp.succ;
            if (temp.succ == before) {
                temp.succ = new SLLNode<E>(o, before);
            } else
                System.out.println("Elementot go nema vo listata!");
        } else
            System.out.println("Listata e prazna!");
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> temp = first;
            while (temp.succ != null)
                temp = temp.succ;
            temp.succ = new SLLNode<E>(o, null);
        } else
            insertFirst(o);
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> temp = first;
            first = first.succ;
            return temp.data;
        } else
            System.out.println("Listata e prazna!");
        return null;
    }

    public void delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> temp = first;
            if (first == node) {
                this.deleteFirst();
                return;
            }
            while (temp.succ != node && temp.succ != null) {
                temp = temp.succ;
            }
            if (temp.succ == node) {
                temp.succ = node.succ;// temp.succ = temp.succ.succ;
//                   return node.data;
            } else {
                System.out.println("Elementot ne postoi vo listata!");
                //  return null;
            }
        } else {
            System.out.println("Listata e prazna!");
            // return null;
        }
    }

    public void merge(MySLL<E> node) {
        if (first != null) {
            SLLNode<E> temp = first;
            while (temp.succ != null)
                temp = temp.succ;
            temp.succ = node.getFirst();
        } else
            first = node.getFirst();
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> temp = first;
            while (!temp.data.equals(o) && temp.succ != null)
                temp = temp.succ;
            if (temp.data.equals(o)) {
                return temp;
            } else {
                System.out.println("Elementot ne postoi vo lista!");
            }
        } else {
            System.out.println("Listata e prazna!");
            return null;
        }
        return null;
    }
}
