package driverseducation;

public class driversed {
    public static void returnHourMinSecond(int seconds) {
        int totalHours = seconds / 3600;
        seconds %= 3600;
        int totalMinutes = seconds / 60;
        seconds %= 60;

        System.out.println("hours: "+totalHours+" minutes: "+totalMinutes+" seconds: "+seconds);
    }

    public static void main(String[] args) {
        returnHourMinSecond(3669);
    }
}
