class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null || matchsticks.length<4) return false;

        long sum=0;
        for(int stick : matchsticks) sum+=stick;
        if(sum%4!=0) return false;

        int side = (int)(sum/4);
        for(int stick : matchsticks){
            if(stick > side) return false;
        }

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] sides = new int[4];

        return dfs(matchsticks, sides, side, 0);
    }

    public boolean dfs(int[] nums, int[] sides, int side, int idx){
        if(idx==nums.length){
            return sides[0]==side && sides[1]==side && sides[2]==side;
        }

        int stick = nums[idx];
        for(int i=0; i<4; i++){
            if(sides[i]+stick<=side){
                sides[i]+=stick;
                if(dfs(nums, sides, side, idx+1)) return true;
                sides[i]-=stick;
            }
            if(sides[i]==0) break;
        }
        return false;
    }

    public void reverse(int[] nums){
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}