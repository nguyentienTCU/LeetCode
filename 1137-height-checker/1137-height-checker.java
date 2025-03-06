class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] heightClone = heights.clone();
        for(int i=heightClone.length; i>0; i--){
            for (int j=0; j<heightClone.length-1; j++){
                if(heightClone[j]>heightClone[j+1]){
                    int temp = heightClone[j];
                    heightClone[j] = heightClone[j+1];
                    heightClone[j+1] = temp;
                }
            }
        }

        for(int i=0; i<heights.length; i++){
            if(heights[i]!=heightClone[i]){
                count++;
            }
        } return count;
    }
}