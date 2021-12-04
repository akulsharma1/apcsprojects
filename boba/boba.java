package boba;

import java.util.ArrayList;

public class boba extends drinks {
    ArrayList<String> marcosSixPack = new ArrayList<String>();

    public void addTopping(String topping) {
        marcosSixPack.add(topping);
    }

    public String getTopping(int index) {
        return marcosSixPack.get(index);
    }
        
    public void replaceTopping(int index, String topping) {
        marcosSixPack.set(index, topping);
    }
    
}
