class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        int L = beginWord.length();
        //pattern map: patern -> list of words of that pattern
        Map<String, List<String>> map = new HashMap<>();
        for(String word : wordList){
            for(int i=0; i<L; i++){
                String pattern = word.substring(0,i)+"*"+word.substring(i+1);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int count = 1;
        queue.offer(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();    //how many nodes are in a level

            //bfs processes all nodes at level before leaving to level d+1
            //use for loop to track the level
            for(int i=0; i<size; i++){
                String cur = queue.poll();
                if(cur.equals(endWord)){
                    return count;
                }

                for(int j=0; j<L; j++){
                    String pattern = cur.substring(0,j)+ "*" + cur.substring(j+1);
                    List<String> neighbors = map.getOrDefault(pattern, Collections.emptyList());

                    for (String nei : neighbors) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}