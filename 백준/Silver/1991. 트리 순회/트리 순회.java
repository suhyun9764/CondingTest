
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
        nodes = new Node[N+1];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0)-'A';
            int leftChild = st.nextToken().charAt(0)-'A';
            int rightChild = st.nextToken().charAt(0)-'A';
            if(isNotAlphabet(leftChild)){
                leftChild = -1;
            }

            if(isNotAlphabet(rightChild)){
                rightChild = -1;
            }
            nodes[root] = new Node(root,leftChild,rightChild);
        }
        printPre(0);
        System.out.println();
        printMid(0);
        System.out.println();
        printLast(0);

    }

    private static void printLast(int root) {
        int leftChild = nodes[root].leftChild;
        int rightChild = nodes[root].rightChild;

        if(leftChild!=-1)
            printLast(leftChild);

        if(rightChild!=-1)
            printLast(rightChild);

        System.out.print((char) (root+'A'));
    }

    private static void printMid(int root) {
        int leftChild = nodes[root].leftChild;
        int rightChild = nodes[root].rightChild;

        if(leftChild!=-1)
            printMid(leftChild);

        System.out.print((char) (root+'A'));

        if(rightChild!=-1)
            printMid(rightChild);
    }

    private static void printPre(int root) {
        System.out.print((char) (root+'A'));
        int leftChild = nodes[root].leftChild;
        int rightChild = nodes[root].rightChild;

        if(leftChild!=-1)
            printPre(leftChild);

        if(rightChild!=-1)
            printPre(rightChild);

    }

    static class Node{
        int root;
        int leftChild;
        int rightChild;

        public Node(int root, int leftChild, int rightChild) {
            this.root = root;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private static boolean isNotAlphabet(int input) {
        if (input < 0 || input >= 26)
            return true;

        return false;
    }

}
