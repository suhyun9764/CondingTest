import java.util.*;

class Solution {
    char[] oper = {'+','-','*'};
    List<Long> numberList = new ArrayList<>();
    List<Character> operatorList = new ArrayList<>();
    long answer = 0;
    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<expression.length();i++){
            char cur = expression.charAt(i);
            if(cur=='*'||cur=='+'||cur=='-'){
                numberList.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operatorList.add(cur);
                continue;
            }
            
            sb.append(cur);
        }
        numberList.add(Long.parseLong(sb.toString()));
        // for(int i=0;i<numberList.size();i++){
        //     System.out.print(numberList.get(i)+" ");
        // }
        dfs(0,new char[3], new boolean[3]);
  
        return answer;
    }
    
    private void dfs(int depth, char[] order, boolean[] visit){
        if(depth==3){
            long result = calculate(order);
            answer = Math.max(answer,Math.abs(result));
            return;
        }
        
        for(int i=0;i<3;i++){
            if(visit[i]) continue;
            visit[i] = true;
            order[depth] = oper[i];
            dfs(depth+1,order,visit);
            visit[i] = false;
        }
    }
    
    private long calculate(char[] order){
        List<Long> numbers = new ArrayList(numberList);
        List<Character> operators = new ArrayList(operatorList);
        
        for(int i=0;i<order.length;i++){
            char curOper = order[i];
            
            for(int j=0;j<operators.size();j++){
                char curO = operators.get(j);
                if(curO==curOper){
                    long num1 = numbers.get(j);
                    long num2 = numbers.get(j+1);
                    long result = 0;
                    if(curO=='*'){
                        result = num1*num2;
                    }else if(curO=='+'){
                        result = num1+num2;
                    }else{
                        result = num1-num2;
                    }
                      numbers.set(j,result);
                        numbers.remove(j+1);
                    operators.remove(j);
                    j--;
                }
              
            }
        }
        
        return numbers.get(0);
        
    }
}