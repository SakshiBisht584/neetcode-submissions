class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]","");
        int st=0;
        int end=s.length()-1;
        while(st<end){
            if(s.charAt(st++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
