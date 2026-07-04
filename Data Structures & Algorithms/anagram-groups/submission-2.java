class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> h=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if(!h.containsKey(key)){
                h.put(key,new ArrayList<>());
            }
            h.get(key).add(s);
            
        }
        return new ArrayList<>(h.values());
        
    }
}
