package part2;

import java.util.ArrayList;
import java.util.List;

public class Woolies {

    public static void main(String[] args) {

        Bridge troll = new Bridge();
        List<Woolie> woolies = new ArrayList<>();
        woolies.add(new Woolie("Bruce", 7, Woolie.City.COURTWALD, Woolie.City.GLASSDELL, troll));
        woolies.add(new Woolie("Bobby", 8, Woolie.City.GLASSDELL, Woolie.City.COURTWALD, troll));
        woolies.add(new Woolie("Ahmed", 5, Woolie.City.COURTWALD, Woolie.City.GLASSDELL, troll));
        woolies.add(new Woolie("Chris", 6, Woolie.City.GLASSDELL, Woolie.City.COURTWALD, troll));

        for (int i = 0; i < 6; i++) {
            Thread thread = new Thread(woolies.get(i));
            thread.start();
        }
    }

}
