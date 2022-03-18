package towerofhanoi;

public class toh {
    public static void towerofhanoi(int disk, String from, String to, String helper) {
        if (disk == 1) System.out.println("Moving disk 1 from rod " + from + " to rod " + to);
        else {
            towerofhanoi(disk - 1, from, helper, to);
            System.out.println("Moving disk " + disk + " from rod " + from + " to rod " + to);
            towerofhanoi(disk - 1, helper, to, from);
        }
    }

    public static void main(String[] args) {
        towerofhanoi(3, "A", "C", "B");
    }
}
