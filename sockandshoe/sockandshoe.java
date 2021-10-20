package sockandshoe;
public class sockandshoe {
    public static void main(String[] args) {
        shoe defaultshoe = new shoe();
        sock s = new sock(11.5, "black");
        shoe customshoe = new shoe("adidas", 12, "grey", s);
        customshoe.setSockColor("blue");
        System.out.println(customshoe.getSockColor());
    }
}

class sock {
    private double size;
    private String color;

    public sock() {
        size = 10;
        color = "white";
    }

    public sock(double s, String c) {
        size = s;
        color = c;
    }
    public double returnSize() {
        return size;
    }

    public String returnColor() {
        return color;
    }
    public void setSockColor(String c) {
        color = c;
    }
}

class shoe {
    private String brand;
    private double size;
    private String color;
    private sock sockies;
    public shoe() {
        brand = "nike";
        size = 10;
        color = "white";
        sockies = new sock();
    }
    public shoe(String b, double s, String c, sock sockk) {
        brand = b;
        size = s;
        color = c;
        sockies = sockk;
    }

    public String getBrand() {
        return brand;
    }
    public double getSize() {
        return size;
    }
    public String getColor() {
        return color;
    }
    public double getSockSize() {
        return sockies.returnSize();
    }
    public String getSockColor() {
        return sockies.returnColor();
    }
    public void setSockColor(String c) {
        sockies.setSockColor(c);
    }
}
