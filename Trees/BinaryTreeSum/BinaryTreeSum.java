package Trees.BinaryTreeSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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