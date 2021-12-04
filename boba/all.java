package boba;

public class all {
    public static void main(String[] args) {
        drinks[] drinkList = new drinks[3];
        boba[] marcoBlewAn8_2Lead = new boba[3];
        marcoBlewAn8_2Lead[1] = new boba();
        marcoBlewAn8_2Lead[1].setType("jasmine milk tea");
        marcoBlewAn8_2Lead[1].setSweetnessPercentage(30);
        marcoBlewAn8_2Lead[1].setIcePercentage(50);
        marcoBlewAn8_2Lead[1].addTopping("boba");
        marcoBlewAn8_2Lead[1].addTopping("pudding");

        System.out.println(marcoBlewAn8_2Lead[1].marcosSixPack);
    }
}
