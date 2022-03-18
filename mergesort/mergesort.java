package mergesort;

public class mergesort {
    public static void mergeTogether(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int x = 0;
        int y = 0;
        int z = 0;
        while (x < left && y < right) {
            if (leftArr[x] <= rightArr[y]) {
                arr[z] = leftArr[x];
                z++;
                x++;
            } else {
                arr[z] = rightArr[y];
                z++;
                y++;
            }
        }

        while (y < right) {
            arr[z] = rightArr[y];
            z++;
            y++;
        }
        
        while (x < left) {
            arr[z] = leftArr[x];
            z++;
            x++;
        }

        
    }
    public static void mergeSort(int[] arr, int arrLength) {
        if (arrLength == 1) return;
        int middlePos = arrLength/2;
        int[] left = new int[middlePos];
        int[] right = new int[arrLength - middlePos];

        for (int i = 0; i < middlePos; i++) {
            left[i] = arr[i];
        }
        for (int i = middlePos; i < arrLength; i++) {
            right[i - middlePos] = arr[i];
        }

        mergeSort(left, middlePos);
        mergeSort(right, arrLength - middlePos);
        mergeTogether(arr, left, right, middlePos, arrLength-middlePos);
    }

    public static void main(String[] args) {
        int[] nums = {12, 14, 12, 22, 17, 99, 202, 348, 485, 2382, 400, 2};
        mergeSort(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
