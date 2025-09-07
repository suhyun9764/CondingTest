import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        
        double aNum = 0;
        double bNum = 0;
        double both = 0;
        
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(int i=0;i<charArr1.length-1;i++){
            StringBuilder sb = new StringBuilder();
            if(Character.isAlphabetic(charArr1[i])&&Character.isAlphabetic(charArr1[i+1])){
                sb.append(charArr1[i]);
                sb.append(charArr1[i+1]);
                String lowerCase = sb.toString().toLowerCase();
                map1.put(lowerCase,map1.getOrDefault(lowerCase,0)+1);
                aNum ++;
            }
        
        }
        
        for(int i=0;i<charArr2.length-1;i++){
            StringBuilder sb = new StringBuilder();
            if(Character.isAlphabetic(charArr2[i])&&Character.isAlphabetic(charArr2[i+1])){
                sb.append(charArr2[i]);
                sb.append(charArr2[i+1]);
                String lowerCase = sb.toString().toLowerCase();
                map2.put(lowerCase,map2.getOrDefault(lowerCase,0)+1);
                bNum ++;
            }
            
        }
        
        for(String key : map1.keySet()){
            System.out.println(key);
            both += Math.min(map1.get(key),map2.getOrDefault(key,0));
        }
         
        double rate = 0;
        
        if(aNum==0&&bNum==0){
            rate = 1;
        }else{
            rate =  both/(aNum+bNum-both);
        }
        
        return (int)(Math.floor(rate*65536));
    }
}