package arrayfunctions;

public class arrayfunctions {

    public static void main(String[] args) {
        int[] numerators = new int[]{1,2};
        int[] denominators = new int[]{3,4};
        multiply(numerators, denominators);
        divide(numerators, denominators);
    }
    public static int gcd(int num1, int num2) {
        return gcd(num1 % num2, num1);
    }

    public static int lcm(int num1, int num2) {
        return (num1 * num2) / gcd(num1, num2);
    }
    public static void Add(int[] numerators, int[] denominators) {
        int[] fr1 = new int[]{numerators[0], denominators[0]};
        int[] fr2 = new int[]{numerators[1], denominators[1]};
        int[] fraction1 = simplify(fr1);
        int[] fraction2 = simplify(fr2);

        
        

        
    }


    public static void multiply(int[] numerators, int[] denominators) {
        int numerator = numerators[0] * numerators[1];
        int denominator = denominators[0] * denominators[1];

        int[] fracArray = new int[]{numerator, denominator};
        int[] multipliedValues = simplify(fracArray);

        System.out.println(multipliedValues[0] + "/" + multipliedValues[1]);
    }
    public static void divide(int[] numerators, int[] denominators) {
        int numerator = numerators[0] * denominators[1];
        int denominator = numerators[1] * denominators[0];

        int[] fracArray = new int[]{numerator, denominator};
        int[] values = simplify(fracArray);

        if (values[0] % values[1] == 0) {
            values[0] /= values[1];
            System.out.println(values[0]);
        } else {
            System.out.println(values[0] + "/" + values[1]);
        }
    }
    public static int[] simplify(int[] fraction) {
        for (int i = fraction[0]; i > 0; i--) {
            if (fraction[0] % i == 0 && fraction[1] % i == 0) {
                fraction[0] /= i;
                fraction[1] /= i;
                return fraction;
            }
        }
        return fraction;
    }
}
