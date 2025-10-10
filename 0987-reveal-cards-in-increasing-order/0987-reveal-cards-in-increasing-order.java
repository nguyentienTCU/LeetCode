class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ans = new int[deck.length];

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<deck.length; i++) q.offer(i);

        for(int card:deck){
            int idx = q.poll();
            ans[idx] = card;
            if(!q.isEmpty()){
                q.offer(q.poll());
            }
        }
        return ans;
    }
}