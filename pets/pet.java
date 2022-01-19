package pets;

public class pet {
    private String name;
    private String sound;
    public pet(String name) {
        this.name = name;
        sound = "no sound";
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public static void main(String[] args) {
        pet[] pets = new pet[3];
        pets[0] = new dog("Romeo", "ruff", "lab");
        pets[1] = new dog("samoyed", "ruff", "golden retriever");
        pets[2] = new cat("juliet", "meow", 4);
        System.out.println(pets[2]);
        System.out.println(pets[0].getSound());
    }

    
}

class cat extends pet {
    private String name;
    private String sound;
    private int numOfLives;
    public cat(String name, String sound, int numOfLives) {
        super(name);
        this.sound = sound;
        this.numOfLives = numOfLives;
    }

    public int getNumOfLives() {
        return numOfLives;
    }

    public void reduceLives() {
        numOfLives--;
    }

    public String toString() {
        return "Name: " + name + "\nSound: " + sound + "\nNumber of lives: " + numOfLives;
    }
}

class dog extends pet {
    private String name;
    private String sound;
    private String breed;
    public dog(String name, String sound, String breed) {
        super(name);
        this.sound = sound;
        this.breed = breed;
    }
    public String getBreed() {
        return breed;
    }

    public String toString() {
        return "Name: " + name + "\nSound: " + sound + "\nBreed: " + breed;
    }
}


/*
    You are able to use pet.getName() and pet.getSound(). However both of these will return null / no sound because the parent defaults are null.
    You can use the child toString() method to return the name and sound of the pet.
    You can't use any of the other child functions like getBreed() because they wouldn't make sense for a parent class.

*/