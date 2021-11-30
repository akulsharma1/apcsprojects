package boba;

public class all {
    public static void main(String[] args) {
        drinks[] drinkList = new drinks[3];
        boba[] bobaList = new boba[3];
        bobaList[1] = new boba();
        bobaList[1].setType("jasmine");
        bobaList[1].setSweetnessPercentage(30);
        bobaList[1].setIcePercentage(50);
        bobaList[1].addTopping("boba");
        bobaList[1].addTopping("pudding");

        System.out.println(bobaList[1].toppingList);
    }
}
