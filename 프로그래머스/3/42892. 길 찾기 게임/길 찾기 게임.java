import java.util.*;

class Solution {
        class Node implements Comparable<Node>{
            int order;
            int x;
            int y;

            Node left = null;
            Node right = null;

            public Node(int order, int x, int y) {
                this.order = order;
                this.x = x;
                this.y = y;
            }

            public int compareTo(Node o) {
                if(this.y==o.y)
                    return this.x-o.x;

                return o.y-this.y;
            }
        }
        public int[][] solution(int[][] nodeinfo) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int n = nodeinfo.length;

            for(int i=1;i<=n;i++){
                pq.add(new Node(i,nodeinfo[i-1][0],nodeinfo[i-1][1]));
            }

             Node root = pq.poll();
            while (!pq.isEmpty()){
                insert(root,pq.poll());
            }

            int[] pre = preorder(root);
            int[] post = postorder(root);

            return new int[][]{pre,post};

        }

        private int[] preorder(Node root) {
            List<Integer> list = preDfs(root, new ArrayList<>());
            int[] arr = new int[list.size()];
            for(int i=0;i<arr.length;i++){
                arr[i] = list.get(i);
            }
            return arr;
        }

        private List<Integer> preDfs(Node node, List<Integer> list) {
            list.add(node.order);
            if(node.left!=null){
                list = preDfs(node.left,list);
            }

            if(node.right!=null){
                list = preDfs(node.right,list);
            }

            return list;
        }

        private int[] postorder(Node root) {
            List<Integer> list = postDfs(root, new ArrayList<>());
            int[] arr = new int[list.size()];
            for(int i=0;i<arr.length;i++){
                arr[i] = list.get(i);
            }
            return arr;
        }

        private List<Integer> postDfs(Node node, List<Integer> list) {
            if(node.left!=null){
                postDfs(node.left,list);
            }

            if(node.right!=null){
                postDfs(node.right,list);
            }

            list.add(node.order);

            return list;
        }

        private void insert(Node parent, Node cur) {
            if(cur.x<parent.x){
                if(parent.left==null){
                    parent.left = cur;
                }else{
                    insert(parent.left,cur);
                }
            }else{
                if(parent.right==null){
                    parent.right = cur;
                }else{
                    insert(parent.right,cur);
                }
            }
        }
    }
