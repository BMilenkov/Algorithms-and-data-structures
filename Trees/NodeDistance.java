package Trees;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class NodeDistance {

    static BNode<String> find(BNode<String> node, String value) {

        if (node == null)
            return null;

        if (node.info.equals(value))
            return node;

        BNode<String> left = find(node.left, value);
        if (left != null) {
            return left;
        }
        return find(node.right, value);
    }

    static BNode<String> LCA(BNode<String> node, String a, String b) {

        if (node == null)
            return null;

        if (node.info.equals(a) || node.info.equals(b))
            return node;

        BNode<String> left = LCA(node.left, a, b);
        BNode<String> right = LCA(node.right, a, b);

        if (left != null && right != null)
            return node;
        else if (left != null)
            return left;
        else return right;
    }

    static int count(BNode<String> lca, BNode<String> node, int depth) {

        if (lca == node)
            return depth;
        if (lca == null)
            return 0;

        int left = count(lca.left, node, depth + 1);
        int right = count(lca.right, node, depth + 1);

        return left == 0 ? right : left;
    }


    public static void main(String[] args) throws Exception {

        int i;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        BNode<String>[] nodes = new BNode[N];
        BTree<String> tree = new BTree<>();


        for (i = 0; i < N; i++)
            nodes[i] = new BNode<>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
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


        int cases = Integer.parseInt(br.readLine());

        for (int l = 0; l < cases; l++) {
            String[] split = br.readLine().split(" +");
            String from = split[0];
            String to = split[1];

            BNode<String> a = find(tree.root, from);
            BNode<String> b = find(tree.root, to);

            if (a == null || b == null) {
                System.out.println("ERROR");
                break;
            }

            BNode<String> LCA = LCA(tree.root, from, to);
            System.out.println((count(LCA, a, 0) + count(LCA, b, 0)) * 2);
        }
        br.close();
    }
}
