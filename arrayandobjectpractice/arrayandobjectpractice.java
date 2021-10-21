package arrayandobjectpractice;

public class arrayandobjectpractice {
    public static void main(String[] args) {
        int[] arr = {12, 14, 19, 17, 21};
        System.out.println(arrayLocate(arr, 1));

        shoe[] sarr = new shoe[3];
        sarr[0] = new shoe();
        sarr[1] = new shoe();
        sarr[2] = new shoe();
        sarr[1].setBrand("Toms");
        sarr[1].setColor("gray");
        sarr[1].setSize(7);

        System.out.println(smartSubstring("Michael", -1, -4));
    }
    public static int arrayLocate(int[] arr, int spot) {
        if (spot >= 0) {
            return arr[spot];
        }
        else {
            int newspot = arr.length - Math.abs(spot);
            return arr[newspot-1];
        }
    }

    public static String smartSubstring(String str, int start, int end) {
        String result = "";
        if (start > 0) {
            for (int i = start; i <= end; i++) {
                result += str.charAt(i-1);
            }
        } else {
            int newStart = str.length() - Math.abs(start) - 1;
            int newEnd = str.length() - Math.abs(end) - 1;
            for (int i = newStart; i>=newEnd; i--) {
                result += str.charAt(i+1);
            }
        }
        return result;
    }
}

class shoe {
    private String brand;
    private double size;
    private String color;

    public shoe(String b, double s, String c) {
        brand = b;
        size = s;
        color = c;
    }

    public shoe() {
        brand = "nike";
        size = 11;
        color = "white";
    }

    public void setBrand(String b) {
        brand = b;
    }
    public void setSize(double s) {
        size = s;
    }
    public void setColor(String c) {
        color = c;
    }
}
