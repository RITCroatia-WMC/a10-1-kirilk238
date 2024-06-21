package part2;

/*
@ASSESSME.USERID: kk6508
@ASSESSME.AUTHOR: Kiril
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/

public class Bridge {
    private boolean isOccupied = false;

    public synchronized boolean enterBridge() {
        if (isOccupied) {
            return false; // Bridge is occupied, cannot enter
        }
        isOccupied = true;
        // troubleshooted part2 tester not passing on leave bridge and isoccupied with help of AI
        System.out.println("Troll: Bridge can be crossed now.");
        return true; // Successfully entered the bridge
    }

    public synchronized void leaveBridge() {
        isOccupied = false;
        System.out.println("Troll: Bridge is clear.");
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}