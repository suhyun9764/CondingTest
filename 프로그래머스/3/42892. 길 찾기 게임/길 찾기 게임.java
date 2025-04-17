import java.util.*;

class Solution {
        public int[][] solution(int[][] nodeinfo) {
            Node[] nodes = new Node[nodeinfo.length];

            for (int i = 0; i < nodeinfo.length; i++) {
                int x = nodeinfo[i][0];
                int y = nodeinfo[i][1];

                Node node = new Node(i+1, x, y);
                nodes[i] = node;
            }
            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o2.y - o1.y;
                }
            });

            Node root = nodes[0];
            for (int i = 1; i < nodes.length; i++) {
                root.insertChild(nodes[i]);
            }

            int[][] answer = new int[2][nodeinfo.length];
            List<Integer> preList = pre(root, new ArrayList<>());
            for(int i=0;i<answer[0].length;i++){
                answer[0][i] = preList.get(i);
            }
            List<Integer> postList = post(root, new ArrayList<>());
            for(int i=0;i<answer[1].length;i++){
                answer[1][i] = postList.get(i);
            }

            return answer;
        }

        private List<Integer> post(Node root, List<Integer> list) {

            if(root.leftChild!=null)
                list = post(root.leftChild,list);
            if(root.rightChild!=null)
                list =post(root.rightChild,list);

            list.add(root.myNumber);
            return list;
        }

        private List<Integer> pre(Node root, List<Integer> list) {
            list.add(root.myNumber);
            if(root.leftChild!=null)
                list = pre(root.leftChild,list);
            if(root.rightChild!=null)
                list =pre(root.rightChild,list);

            return list;
        }

    }

    class Node {
        int myNumber;
        int x;
        int y;
        Node leftChild = null;
        Node rightChild = null;

        public Node(int myNumber, int x, int y) {
            this.myNumber = myNumber;
            this.x = x;
            this.y = y;
        }

        public void insertChild(Node child) {
            if (child.x > this.x) {
                if (this.rightChild == null)
                    this.rightChild = child;
                else {
                    this.rightChild.insertChild(child);
                }
            } else {
                if (this.leftChild == null)
                    this.leftChild = child;
                else {
                    this.leftChild.insertChild(child);
                }
            }
        }
    }