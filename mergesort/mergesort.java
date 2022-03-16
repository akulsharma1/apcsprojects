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

        while (x < left) {
            arr[z] = leftArr[x];
            z++;
            x++;
        }

        while (y < right) {
            arr[z] = rightArr[y];
            z++;
            y++;
        }
    }
    public static void mergeSort(int[] arr, int index) {
        if (index < 2) return;
        int middle = index/2;
        int[] left = new int[middle];
        int[] right = new int[index - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }
        for (int i = middle; i < index; i++) {
            right[i - middle] = arr[i];
        }

        mergeSort(left, middle);
        mergeSort(right, index - middle);
        mergeTogether(arr, left, right, index, index-middle);
    }

    public static void main(String[] args) {
        int[] nums = {12, 14, 12, 22, 17, 99, 202, 348, 485, 2382, 400, 2};
        mergeSort(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
