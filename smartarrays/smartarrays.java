package smartarrays;

public class smartarrays {
    public static void main(String[] args) {
        int[] arr = {12,13,14,15,16};
        System.out.println(indexOf(arr, 69));
    }

    public static int[] add(int[] arr, int value) {
        int[] newarr = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        newarr[arr.length] = value;
        return newarr;
    }

    public static int[] add(int[] arr, int spot, int value) {
        int[] newarr = new int[arr.length+1];
        boolean triggered = false;
        for (int i = 0; i < newarr.length; i++) {
            if (i == spot) {
                newarr[i] = value;
                triggered = true;
            } else if (!triggered){
                newarr[i] = arr[i]; 
            } else {
                newarr[i] = arr[i-1];
            }
        }
        return newarr;
    }

    public static int[] remove(int[] arr) {
        int[] newarr = new int[arr.length-1];
        for (int i = 0; i < newarr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }

    public static int[] remove(int[] arr, int spot) {
        int[] newarr = new int[arr.length-1];
        boolean triggered = false;
        for (int i = 0; i < arr.length; i++) {
            if (i != spot && !triggered) {
                newarr[i] = arr[i];
            } else if (i == spot) {
                triggered = true;
            } else {
                newarr[i-1] = arr[i];
            }
        }
        return newarr;
    }

    public static int[] replace(int[] arr, int spot, int value) {
        int[] newarr = new int[arr.length];
        for (int i = 0; i < newarr.length; i++) {
            if (i == spot)
                newarr[i] = value;
            else 
                newarr[i] = arr[i];
        }
        return newarr;
    }

    public static int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
}

class array {

}
