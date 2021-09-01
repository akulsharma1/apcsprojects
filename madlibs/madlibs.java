package madlibs;
import java.util.*;
public class madlibs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String name;
        System.out.println("male name");
        name = s.nextLine();

        String food1;
        System.out.println("food");
        food1 = s.nextLine();

        String food2;
        System.out.println("food");
        food2 = s.nextLine();

        String food3;
        System.out.println("food");
        food3 = s.nextLine();

        String food4;
        System.out.println("food");
        food4 = s.nextLine();

        String dayofweek;
        System.out.println("day of week");
        dayofweek = s.nextLine();

        String action;
        System.out.println("verb");
        action = s.nextLine();

        int number;
        System.out.println("number");
        number = s.nextInt();
        s.nextLine();

        String item;
        System.out.println("item");
        item = s.nextLine();

        int age;
        System.out.println("age");
        age = s.nextInt();
        s.nextLine();

        double gpa;
        System.out.println("gpa");
        gpa = s.nextDouble();
        s.nextLine();

        String name2;
        System.out.println("name");
        name2 = s.nextLine();

        String object;
        System.out.println("object");
        object = s.nextLine();

        System.out.println("action");
        String action2 = s.nextLine();

        System.out.println("noun");
        String noun = s.nextLine();

        System.out.println("noun");
        String noun2 = s.nextLine();

        System.out.println("noun");
        String thing = s.nextLine();

        System.out.println("verb");
        String verb = s.nextLine();

        System.out.println("adjective");
        String adjective = s.nextLine();

        System.out.println("adjective");
        String anotheradjective = s.nextLine();

        System.out.println("noun");
        String anotherobject = s.nextLine();

        System.out.println("adjective");
        String thirdadjective = s.nextLine();

        System.out.println("verb");
        String anotherverb = s.nextLine();

        System.out.println("movie");
        String movie = s.nextLine();

        System.out.println("number as string (e.g. six)"); 
        String intAsString = s.nextLine();

        System.out.println("verb");
        String thirdverb = s.nextLine();

        System.out.println("noun");
        String noun3 = s.nextLine();

        System.out.println("object");
        String object2 = s.nextLine();

        System.out.println("object");
        String object3 = s.nextLine();

        System.out.println("object");
        String object4 = s.nextLine();

        printMadLibs(name, food1, food2, food3, food4, dayofweek, action, number, item, age, gpa, name2, object, action2, noun, noun2, thing, verb, adjective, anotheradjective, anotherobject, thirdadjective, anotherverb, movie, intAsString, thirdverb, noun3, object2, object3, object4);
    }
    public static void printMadLibs(String name, String food1, String food2, String food3, String food4, String dayofweek, String action,
    int number, String item, int age, double gpa, String name2, String object, String action2, String noun, String noun2, String thing, String verb,
    String adjective, String anotheradjective, String anotherobject, String thirdadjective, String anotherverb, String movie, String intAsString,
    String thirdverb, String noun3, String object2, String object3, String object4) {
        System.out.println("Once upon a time there was a person named "+name);
        System.out.println("They liked to eat "+food1+" and "+food2);
        System.out.println("However, "+name+" did not like to eat "+food3+" and he absolutely hated "+food4);
        System.out.println("On "+dayofweek+", "+name+" went to go "+action);
        System.out.println("While he was there, he also bought "+number+" "+item+"s");
        System.out.println(name+" is "+(age+1)+" minus 1 years old");
        System.out.println("His GPA in high school was "+gpa);
        System.out.println("Now we will remake humpty dumpty.");
        System.out.println(name2+" sat on a "+object);
        System.out.println(name2+" had a great "+action2);
        System.out.println("All the king's "+noun+"and all the king's "+noun2+" couldn't put "+name2+" together again!");
        System.out.println("Now we will remake some of the lines from brooklyn nine-nine.");
        System.out.println("This "+thing+" is eating me alive. I can't "+verb+" anymore.");
        System.out.println("I spent all these years trying to be the "+adjective+" guy, the man in the "+ anotheradjective+" "+anotherobject+". I'm not becoming like them... I am them.");
        System.out.println("What are you doing, "+thirdadjective+"?");
        System.out.println("I’m doing the best "+anotherverb+" from " +movie+". Actually--"+intAsString+" of me are doing the best speech from "+movie);
        System.out.println("Store was "+thirdverb+" about two hours ago. "+noun3+" disabled the "+object2);
        System.out.println("They mostly took "+object3+" and "+object4);

    }
}
