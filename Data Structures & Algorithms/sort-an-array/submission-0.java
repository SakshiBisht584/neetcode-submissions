class Solution {
    public int partition(int[] nums,int st,int end){
        int pivot=nums[end];
        int i=st-1;
        for(int j=st;j<end;j++){
            if(nums[j]<pivot){
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        i++;
            int temp=nums[i];
            nums[i]=nums[end];
            nums[end]=temp;
        return i;

    }
    public void quickSort(int[] nums,int start,int end){
        if(start<end){
        int pivot=partition(nums,start,end);
        quickSort(nums,start,pivot-1);
        quickSort(nums,pivot+1,end);
        }
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
}