
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            
            if (isNotAlphabet(left)) {
                left = -1;
            }
            if (isNotAlphabet(right)) {
                right = -1;
            }
            nodes[root] = new Node(root, left, right);
        }
        
        // 전위
        printPre(0);
        System.out.println();
        // 중위
        printMid(0);
        System.out.println();
        // 후위
        printPost(0);

    }

    private static void printPre(int root) {
        System.out.print((char)(root+'A'));
        if(nodes[root].left==-1&&nodes[root].right==-1 )
            return;

        if(nodes[root].left!=-1)
            printPre(nodes[root].left);

        if(nodes[root].right!=-1)
            printPre(nodes[root].right);

    }

    private static void printMid(int root) {
        if(nodes[root].left==-1&&nodes[root].right==-1 ){
            System.out.print((char)(root+'A'));
            return;
        }


        if(nodes[root].left!=-1)
            printMid(nodes[root].left);

        System.out.print((char)(root+'A'));

        if(nodes[root].right!=-1)
            printMid(nodes[root].right);
    }

    private static void printPost(int root) {
        if(nodes[root].left==-1&&nodes[root].right==-1 ){
            System.out.print((char)(root+'A'));
            return;
        }


        if(nodes[root].left!=-1)
            printPost(nodes[root].left);

        if(nodes[root].right!=-1)
            printPost(nodes[root].right);

        System.out.print((char)(root+'A'));
    }

    private static boolean isNotAlphabet(int input) {
        if (input < 0 || input >= 26)
            return true;

        return false;
    }

    static class Node {
        int root;
        int left;
        int right;

        public Node(int root, int left, int right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }
}
