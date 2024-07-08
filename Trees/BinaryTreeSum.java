package Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
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


}

public class BinaryTreeSum {
    static int maxPateka(BNode<Integer> node,int prev_val, int prev_len ){
        if(node==null)
            return prev_len;
        int curr = node.info;
        if(curr== prev_val+1){
            int levo= maxPateka(node.left,curr,prev_len+1);
            int desno= maxPateka(node.right,curr,prev_len+1);

            return Math.max(levo,desno);
        }
        int levo= maxPateka(node.left,curr,1);
        int desno= maxPateka(node.right,curr,1);
        int pateka = Math.max(levo,desno);
        return pateka;
    }

    static int maxPatekaCall(BNode<Integer> root){
        if(root == null)
            return 0;
        return maxPateka(root,root.info-1,0);
    }

    public static void main(String[] args) throws Exception {

        int index=0;
        String action="";

        String line="";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (int i=0;i<N;i++)
            nodes[i] = new BNode<Integer>();

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = Integer.parseInt(st.nextToken());
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }
        br.close();

        // vasiot kod ovde
        System.out.println("Maximum Path Length: " + maxPatekaCall(tree.root));

    }
}