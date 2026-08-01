class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            int j=i+1;
            boolean flag=false;
            while(j<n && flag==false){
                if(temperatures[j]>temperatures[i]){
                    flag=true;
                }
                else j++;
            }
            if(flag==true) arr[i]=j-i;
            else arr[i]=0;
        }
        return arr;
    }
}
