package DLL.DLLBattalion1;

import java.util.Scanner;

public class DLLNode<E> {
    protected E element;
    protected DLLNode<E> prev, succ;
    protected int count;

    public DLLNode(E element, DLLNode<E> prev, DLLNode<E> succ) {
        this.element = element;
        this.prev = prev;
        this.succ = succ;
        this.count = 1;
    }

    @Override
    public String toString() {
        return element.toString() + ",Brojot na pojavuvanja: " + this.count;
    }
}

class MyDLL<E> {
    DLLNode<E> first, last;

    public MyDLL() {
        this.first = null;
        this.last = null;

    }

    public void insertFirst(E o) {
        DLLNode<E> node = new DLLNode<>(o, null, first);
        if (first == null) {
            last = node;
        } else {
            first.prev = node;
        }
        first = node;
    }

    public void insertLast(E o) {
        if (first == null) {
            insertFirst(o);
        } else {
            DLLNode<E> node = new DLLNode<>(o, last, null);
            last.succ = node;
            last = node;
        }
    }

    public void setFirst(DLLNode<E> node) {
        first = node;
    }

    public void setLast(DLLNode<E> node) {
        last = node;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {
        return last;
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
        } else {
            DLLNode<E> node = new DLLNode<>(o, after, after.succ);
            after.succ.prev = node;
            after.succ = node;
        }
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
        } else {
            DLLNode<E> node = new DLLNode<>(o, before.prev, before);
            before.prev.succ = node;
            before.prev = node;
        }
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> temp = first;
            first = first.succ;
            if (first != null) {
                first.prev = null;
            }
            if (first == null) {
                last = null;
            }
            return temp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> temp = last;
                last = last.prev;
                last.succ = null;
                return temp.element;
            }
        }
        return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
           return deleteFirst();
        }
        if (node == last) {
           return deleteLast();
        }
        node.prev.succ = node.succ;
        node.succ.prev = node.prev;
        return node.element;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int size = 0;
        DLLNode<E> temp = first;
        while (temp != null) {
            size++;
            temp = temp.succ;
        }
        return size;
    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> temp = first;
            while (!temp.element.equals(o) && temp.succ != null)
                temp = temp.succ;
            if (temp.element.equals(o)) {
                return temp;
            } else {
                System.out.println("Elementot go nema vo listata!");
            }
        } else {
            System.out.println("Listata e prazna!");
        }
        return null;
    }

    public void removeDuplicateAndCountNodeWithWhileLoop() {
        if (first != null) {
            DLLNode<E> temp = first;
            while (temp != null) {
                DLLNode<E> temp2 = temp.succ;
                while (temp2 != null) {
                    if (temp.element.equals(temp2.element)) {
                        temp.count++;
                        if (temp2 == last) {
                            last = temp2.prev;
                        }
                        temp2.prev.succ = temp2.succ;
                        if (temp2.succ != null) {
                            temp2.succ.prev = temp2.prev;
                        }
                    }
                    temp2 = temp2.succ;
                }
                temp = temp.succ;
            }
        } else {
            System.out.println("Listata e prazna!");
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        if (first != null) {
            DLLNode<E> temp = first;
            stringBuilder.append(temp.element);
            temp = temp.succ;
            while (temp != null) {
                stringBuilder.append("<->" + temp.element);
                temp = temp.succ;
            }
        } else {
            stringBuilder.append("Listata e prazna!!!");
        }
        return stringBuilder.toString();
    }

    public void removeDuplicateAndCountWithForStatement() {
        if (first != null) {
            for (DLLNode<E> temp = first; temp != null; temp = temp.succ) {
                for (DLLNode<E> temp2 = temp.succ; temp2 != null; temp2 = temp2.succ) {
                    if (temp.element.equals(temp2.element)) {
                        if (temp2 == last) {
                            last = temp2.prev;
                        }
                        temp2.prev.succ = temp2.succ;
                        if (temp2.succ != null) {
                            temp2.succ.prev = temp2.prev;
                        }
                    }
                }
            }
        } else {
            System.out.println("Listata e prazna!");
        }
    }

    public boolean isPalindrome() {
        DLLNode<E> posleden = last;
        for (DLLNode<E> poceten = first; poceten.succ != null; poceten = poceten.succ) {
            if (!poceten.element.equals(posleden.element))
                return false;
            posleden = posleden.prev;
        }
        return true;
    }

    void mirror() {
        DLLNode<E> temp = null;
        DLLNode<E> current = first;
        last = first;
        while (current != null) {
            temp = current.prev;
            current.prev = current.succ;
            current.succ = temp;
            current = current.prev;
        }
        if (temp != null && temp.prev != null) {
            first = temp.prev;
        }
    }

    public static void main(String[] args) {
        MyDLL<Integer> list = new MyDLL<>();
        list.insertLast(4);
        list.insertLast(9);
        list.insertLast(4);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(8);
        list.insertLast(9);
        System.out.println("Listata PRED:\n");
        System.out.println(list);

        list.removeDuplicateAndCountWithForStatement();
        System.out.println("Listata POSLE: \n");
        System.out.println(list);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MyDLL<Integer> list1 = new MyDLL<>();
        for (int i = 0; i < n; i++) {
            list1.insertLast(scanner.nextInt());
        }
        scanner.close();
        System.out.println(list1.isPalindrome());
        list.mirror();
        System.out.println(list);
        list1.mirror();
        System.out.println(list1);
    }
}
