package morefrac;

public class fraction {
    private int num;
    private int den;

    public fraction(int n, int d) {
        num = n;
        den = d;
    }

    public int getNumerator() {
        return num;
    }
    public int getDenominator() {
        return den;
    }
}

class mixedFraction {
    private int wholeNum;
    private fraction frac;

    public mixedFraction(int w, int n, int d) {
        frac = new fraction(n, d);
        wholeNum = w;
    }
    public mixedFraction(int w, fraction f) {
        wholeNum = w;
        frac = f;
    }

    public int getFracNumerator() {
        return frac.getNumerator();
    }
    public int getFracDenominator() {
        return frac.getDenominator();
    }

    public int getWholeNum() {
        return wholeNum;
    }

    public void setWholeNum(int num) {
        wholeNum = num;
    }
}
