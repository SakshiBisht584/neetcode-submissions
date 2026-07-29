class Solution {
    class pair{
        String first;
        int second;
        pair(String f, int s){
            first=f;
            second=s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(beginWord,1));
        HashSet<String> st = new HashSet<>(wordList);
        
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.poll();
            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++){
                for(char j='a';j<='z';j++){
                    char[] newword=word.toCharArray();
                    newword[i]=j;
                    String newWord= new String(newword);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new pair(newWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
