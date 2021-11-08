package roadrace;

import java.util.*;
public class roadrace {
    
    
    public static void bubbleSort(player[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j].getTime() > arr[j+1].getTime()) {
                    player temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of players");
        int playerCount = s.nextInt();
        s.nextLine();

        player[] players = new player[playerCount];

        for (int i = 0; i < playerCount; i++) {
            System.out.println("Enter player " + (i + 1) + " time");
            int time = s.nextInt();
            s.nextLine();
            System.out.println("Enter player " + (i + 1) + " gender");
            String gender = s.nextLine();
            
            players[i] = new player(time, gender);
        }
        bubbleSort(players);
        overallWinners(players);
        femaleWinners(players);
        maleWinners(players);
        

    }
    public static void overallWinners(player[] players) {
        players[0].setAward();
        players[1].setAward();
        System.out.println("Overall winner time: "+players[0].getTime()+" Overall winner gender: "+players[0].getGender());
    }
    public static void maleWinners(player[] players) {
        int counter = 0;
        for (int i = 2; i < players.length; i++) {
            if (counter <= 2 && players[i].getGender().equals("M")) {
                counter++;
                System.out.println("Male "+counter+" winner time: "+players[i].getTime());
            }
        }
    }
    public static void femaleWinners(player[] players) {
        int counter = 0;
        for (int i = 2; i < players.length; i++) {
            if (counter <= 1 && players[i].getGender().equals("F")) {
                counter++;
                System.out.println("Female "+counter+" winner time: "+players[i].getTime());
            }
        }
    }



}

class player {
    private int time;
    private String gender;
    private boolean hasAward;

    public player(int time, String gender) {
        this.time = time;
        this.gender = gender;
    }

    public void setAward() {
        this.hasAward = true;
    }

    public boolean getAwardStatus() {
        return hasAward;
    }

    public int getTime() {
        return time;
    }

    public String getGender() {
        return gender;
    }

}
