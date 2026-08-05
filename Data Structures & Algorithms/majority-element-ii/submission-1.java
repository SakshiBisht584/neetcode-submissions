class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int l=nums.length;
        List<Integer> ans= new ArrayList<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int n:nums){
                    map.put(n,map.getOrDefault(n,0)+1);
                
            
        }
        for(int num: map.keySet()){
            if(map.get(num)>l/3){
                ans.add(num);
            }
        }
        return ans;
    }
}