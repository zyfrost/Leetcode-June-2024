class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        int m = arr2.length;

        for (int i = 0; i < arr1.length; i++) {
            max = Math.max(max, arr1[i]);
        }
        // freq Array
        int[] freqArr = new int[max + 1];
        for (int i = 0; i < arr1.length; i++) {
            int index = arr1[i];
            freqArr[index]++;
        }

        int j = 0;
        for (int i = 0; i < m; i++) {
            int element = arr2[i];
            while (freqArr[element] > 0) {
                arr1[j] = element;
                j++;
                freqArr[element]--;

            }

        }

        for(int i = 0; i< max + 1; i++){
             while (freqArr[i] > 0) {
                arr1[j] = i;
                j++;
                freqArr[i]--;

            }
        }
        return arr1;
    }
}
