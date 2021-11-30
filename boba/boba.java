package boba;

import java.util.ArrayList;

public class boba extends drinks {
    ArrayList<String> toppingList = new ArrayList<String>();

    public void addTopping(String topping) {
        toppingList.add(topping);
    }

    public String getTopping(int index) {
        return toppingList.get(index);
    }
        
    public void replaceTopping(int index, String topping) {
        toppingList.set(index, topping);
    }
    
}
