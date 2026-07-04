class Solution {
    public int majorityElement(int[] nums) {
        int freq=1;
        int ans=nums[0];
        for(int i=0;i<nums.length;i++){
            if(freq==0){
                ans=nums[i];
                freq=1;
            }
            if(nums[i]==ans){
                freq++;
            }
            else{
                freq--;
            }
        }
        return ans;
    }
}