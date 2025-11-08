class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> flips = new ArrayList<>();
        for(int size = arr.length; size > 1; size--){
            int maxIdx = 0;
            for(int i=1; i<size; i++){
                if(arr[maxIdx]<arr[i]) maxIdx=i;
            }

            if(maxIdx == size-1) continue;

            if(maxIdx!=0){
                flip(arr, maxIdx+1);
                flips.add(maxIdx+1);
            }

            flip(arr, size);
            flips.add(size);
        }
        return flips;
    }

    private void flip(int[] arr, int k){
        int left = 0;
        int right = k-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}