package array2;

public class array2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] *= 5;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            
            if (j % 3 == 0 && j != 0) {
                arr[j] -= 6;
            }
        }
        System.out.println("----");
        for (int x = 0; x < arr.length; x++) {
            System.out.println(arr[x]);
        } 
    }
}
