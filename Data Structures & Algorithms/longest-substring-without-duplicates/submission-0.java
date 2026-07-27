class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb=new StringBuilder();
        int max=0;
        for(int i=0;i<s.length();i++){
            while(sb.length()!=0 && sb.indexOf(String.valueOf(s.charAt(i)))!=-1){
                sb.deleteCharAt(0);
            }
            sb.append(s.charAt(i));
            max=Math.max(max,sb.length());
        }
        return max;
    }
}
