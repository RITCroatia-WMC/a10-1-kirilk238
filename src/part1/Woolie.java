package part1;

/*
@ASSESSME.USERID: kk6508
@ASSESSME.AUTHOR: Kiril
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/

public class Woolie extends Thread {
    public String name;
    private int crossingTime;
    private String startingCity;
    private String destinationCity;

    static class City {
        public static final String COURTWALD = "Courtwald";
        public static final String GLASSDELL = "Glassdell";
    }

    public Woolie(String name, int crossingTime, String startingCity, String destinationCity) {
        this.name = name;
        this.crossingTime = crossingTime;
        this.startingCity = startingCity;
        this.destinationCity = destinationCity;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(name + " has arrived at the bridge at " + startingCity + ".");

        try {
            System.out.println(name + " is starting to cross.");
            for (int i = 1; i <= crossingTime; i++) {
                System.out.println("\t" + name + ": " + i + " second" + (i > 1 ? "s." : "."));
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println(name + " arrives at " + destinationCity + ".");

    }

    public static void main(String[] args) {
        new Woolie("Albert", 5, "Courtwald", "Glassdell").start();
        new Woolie("Beatrice", 3, "Glassdell", "Courtwald").start();
        new Woolie("Charlie", 7, "Courtwald", "Glassdell").start();
        new Woolie("Darlene", 2, "Glassdell", "Courtwald").start();
    }

}