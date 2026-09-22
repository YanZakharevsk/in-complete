public class Solution {
    public boolean isMatch(String s,  String p){
        int i;
        if(!p.contains("?") && !p.contains("*")){
            if(s.equals(p)) return true;
            else return false;
        }
        int k = 0;
        for (i = 0; i < Math.min(s.length(), p.length()); i++) {
            if(s.charAt(i) == p.charAt(k)){
                k++;
                continue;
            }
            else if(p.charAt(k) == '?'){
                k++;
                continue;
            }else if(p.charAt(k) == '*' && k == p.length() - 1) return true;
            else if(p.charAt(k) == '*'){
                k++;
                while(p.charAt(k) != s.charAt(i)){
                    i++;
                }
                if(k < p.length() - 1) k++;
            }else{
                return false;
            }
        }
        if(s.length() != i) return false;
        return true;
    }
}
