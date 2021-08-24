package madlibs;
import java.util.*;
public class madlibs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name;
        System.out.println("male name");
        name = s.nextLine();
        //System.out.println("name"+ name);
    }
    public void printMadLibs(String name, String food1, String food2, String food3, String food4, String dayofweek, String action,
    int number, String item, int age, double gpa, int int1, int int2, int int3, int int4, int int5) {
        System.out.println("Once upon a time there was a person named "+name);
        System.out.println("They liked to eat "+food1+" and "+food2);
        System.out.println("However, "+name+" did not like to eat "+food3+" and he absolutely hated "+food4);
        System.out.println("On "+dayofweek+", "+name+" went to go "+action);
        System.out.println("While he was there, he also bought "+number+" "+item+"s");
        System.out.println(name+" is "+age+" years old");
        System.out.println("His GPA in high school was "+gpa);
        System.out.println("idk how to continue the story but here are some variables: "+int1+" "+int2+" "+int3+" "+int4+" "+int5);
    }
}
