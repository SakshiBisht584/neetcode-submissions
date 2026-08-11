class Solution {
    public int happyNum(int n){
        int sum=0;
        while(n>0){
            int pro=n%10;
            pro=pro*pro;
            sum+=pro;
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set= new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            n=happyNum(n);
            if(n==1) return true;
        }
        return false;
    }
}
