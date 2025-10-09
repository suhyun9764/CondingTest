import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        // 층별로 분류
        Map<Integer,List<Node>> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<nodeinfo.length;i++){
            int[] curNode = nodeinfo[i];
            int x = curNode[0];
            int y= curNode[1];
            
            map.putIfAbsent(y,new ArrayList<>());
            map.get(y).add(new Node(x,i+1));
            max = Math.max(max,y);
        }
        
        Node root = map.get(max).get(0);
        for(int i=max-1;i>=0;i--){
            List<Node> nodes = map.get(i);
            if(nodes==null) continue;
            for(Node node : nodes){
                root.insert(node);
            }
        }
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = pre(root);
        answer[1] = post(root);
        return answer;
    }
    
    private int[] pre(Node node){
        List<Integer> list = new ArrayList<>();
        preDfs(node,list);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private void preDfs(Node node,List<Integer> list){
        list.add(node.order);
        if(node.left!=null){
            preDfs(node.left,list);
        }
        
        if(node.right!=null){
            preDfs(node.right,list);
        }
    }
    
    private int[] post(Node node){
        List<Integer> list = new ArrayList<>();
        postDfs(node,list);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
        private void postDfs(Node node,List<Integer> list){
        if(node.left!=null){
            postDfs(node.left,list);
        }
        
        if(node.right!=null){
            postDfs(node.right,list);
        }
        list.add(node.order);
    }
}

class Node{
    int value;
    int order;
    Node left;
    Node right;
    
    public void insert(Node o){
        if(value>o.value){ 
            if(left==null) left = o;
            else
                left.insert(o);
        }else{
            if(right==null) right = o;
            else
                right.insert(o);
        }
    }
    
    public Node(int value,int order){
        this.value = value;
        this.order = order;
    }
    
}