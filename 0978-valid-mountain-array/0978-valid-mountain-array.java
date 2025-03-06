class Solution {
    public boolean validMountainArray(int[] arr) {
        int max = arr[0];
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			if (max<arr[i]) {
				max = arr[i];
                index = i;
			}
		}

        if(index==0||index==arr.length-1){
            return false;
        }
		
		if (arr.length<3) {
			return false;
		} else {
		for (int i = 0; i < index; i++) {
			if (arr[i]>=arr[i+1]) {
				return false;
				}
			}
		
		for (int i = index; i < arr.length-1; i++) {
			if (arr[i]<=arr[i+1]) {
				return false;
				}
			}
		} return true;
    }
}