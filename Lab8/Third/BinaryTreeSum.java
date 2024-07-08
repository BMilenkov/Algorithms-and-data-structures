package Lab8.Third;


import java.util.ArrayList;
import java.util.List;

//uRmC-6BAyi9)b-s
class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}


class BTree<E extends Comparable<E>> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<>(info);
    }


    public void makeRoot(E elem) {
        root = new BNode<>(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }
        return tmp;
    }

    public BNode<E> find(BNode<E> node, E value) {

        if (node == null)
            return null;
        if (node.info.equals(value))
            return node;

        BNode<E> left = find(node.left, value);

        if (left != null)
            return left;

        return find(node.right, value);
    }

    //node is the first left child of curr!
    public int sumLeft(BNode<Integer> node, BNode<Integer> curr) {
        if (node == null)
            return 0;

        else {
            if (node.info < curr.info) {
                return sumLeft(node.left, curr) + sumLeft(node.right, curr) + node.info;
            }
            return sumLeft(node.left, curr) + sumLeft(node.right, curr);
        }
    }

    //node is the first right child of curr!
    public int sumRight(BNode<Integer> node, BNode<Integer> curr) {
        if (node == null)
            return 0;

        else {
            if (node.info > curr.info) {
                return sumRight(node.left, curr) + sumRight(node.right, curr) + node.info;
            }
            return sumRight(node.left, curr) + sumRight(node.right, curr);
        }
    }


    int sumNodesWithOnlyLeftChildren(BNode<Integer> node) {
        if (node == null)
            return 0;

        if (node.left != null && node.right == null)
            return node.info + sumNodesWithOnlyLeftChildren(node.left);

        return sumNodesWithOnlyLeftChildren(node.left) + sumNodesWithOnlyLeftChildren(node.right);
    }


    public int sum(BNode<Integer> node) {
        if (node == null)
            return 0;
        return sum(node.right) + sum(node.left) + node.info;
    }

    boolean isSumTree(BNode<Integer> node) {

        if (node == null)
            return true;

        if (node.left == null || node.right == null)
            return false;

        int ls = sum(node.left);
        int rs = sum(node.right);


        return isSumTree(node.left) || isSumTree(node.right) || (node.info == ls + rs);

    }

    private BNode<E> findLCA(BNode<E> node, E a, E b) {

        if (node == null)
            return null;

        if (node.info.equals(a) || node.info.equals(b))
            return node;

        BNode<E> left = findLCA(node.left, a, b);
        BNode<E> right = findLCA(node.right, a, b);

        if (left != null && right != null)
            return node;
        if (left == null && right == null)
            return null;
        if (left != null)
            return left;
        return right;
    }

    public int sumPathsFromRootToLeafs(BNode<Integer> node, int sum) {
        if (node == null)
            return 0;

        sum = sum * 10 + node.info;

        if (node.left == null && node.right == null) {
            return sum;
        }

        return sumPathsFromRootToLeafs(node.left, sum) + sumPathsFromRootToLeafs(node.right, sum);
    }


    static List<Integer> inorderList = new ArrayList<>();
    public boolean isValidBST(BNode<Integer> root) {
        inorder(root);
        for (int i = 0; i < inorderList.size() - 1; i++) {
            if (inorderList.get(i) >= inorderList.get(i+1))
                return false;
        }
        return true;
    }
    private void inorder(BNode<Integer> node) {
        if (node == null)
            return;
        inorder(node.left);
        inorderList.add(node.info);
        inorder(node.right);
    }
}


public class BinaryTreeSum {
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        tree.root = new BNode<>(3);
        tree.root.left = new BNode<>(5);
        tree.root.left.left = new BNode<>(1);
        tree.root.right = new BNode<>(1);
        tree.root.right.right = new BNode<>(1);
        tree.root.right.right.left = new BNode<>(6);
        tree.root.left.right = new BNode<>(3);
        tree.root.left.right.right = new BNode<>(9);
        tree.root.left.right.left = new BNode<>(2);
        System.out.println(tree.sumPathsFromRootToLeafs(tree.root, 0));
    }


}


//public class BinaryTreeSum {
//    public static void main(String[] args) {
//        BTree<Integer> tree = new BTree<>();
//        tree.root = new BNode<>(10);
//        tree.root.left = new BNode<>(8);
//        tree.root.right = new BNode<>(2);
//
//        // Пример за збирно дрво ako mesto 8 imame 6;
//        //      26
//        //     /  \
//        //   10    16
//        //        /  \
//        //       8    8
//        //      /      \
//        //     2        2
//        BTree<Integer> tree2 = new BTree<>();
//        tree2.root = new BNode<>(26);
//        tree2.root.left = new BNode<>(10);
//        tree2.root.right = new BNode<>(16);
//        tree2.root.right.left = new BNode<>(6);
//        tree2.root.right.right = new BNode<>(6);
//        tree2.root.right.right.right = new BNode<>(2);
//        tree2.root.right.left.right = new BNode<>(2);
////        System.out.println(tree.isSumTree(tree.root));  // true
////        System.out.println(tree2.isSumTree(tree2.root));  // true
//    }
//}


//
//public class BinaryTreeSum {
//
//
//    public static void main(String[] args) throws Exception {
//        int i, j, k;
//        int index;
//        String action;
//
//        String line;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//
//        ArrayList<BNode<Integer>> nodes = new ArrayList<>();
//        BTree<Integer> tree = new BTree<Integer>();
//
//        for (i = 0; i < N; i++)
//            nodes.add(i, new BNode<Integer>());
//
//        for (i = 0; i < N; i++) {
//            line = br.readLine();
//            st = new StringTokenizer(line);
//            index = Integer.parseInt(st.nextToken());
//            nodes.add(index, new BNode<>(Integer.parseInt(st.nextToken())));
//            action = st.nextToken();
//            if (action.equals("LEFT")) {
//                tree.addChildNode(nodes.get(Integer.parseInt(st.nextToken())), BNode.LEFT, nodes.get(index));
//            } else if (action.equals("RIGHT")) {
//                tree.addChildNode(nodes.get(Integer.parseInt(st.nextToken())), BNode.RIGHT, nodes.get(index));
//            } else {
//                // this node is the root
//                tree.makeRootNode(nodes.get(index));
//            }
//        }
//
//        int baranaVrednost = Integer.parseInt(br.readLine());
//
//        br.close();
//        BNode<Integer> curr = tree.find(tree.root, baranaVrednost);
//        System.out.print(tree.sumLeft(curr.left, curr) + " " + tree.sumRight(curr.right, curr));
//    }
//}
