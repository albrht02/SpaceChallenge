/* reading item data and filling up the rockets */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Simulation {

    // Methods
    /* loadItems: loads all items from a text file and returns an ArrayList of Items */
    public ArrayList loadItems(int phaseCode) throws Exception {
        ArrayList<Item> items = new ArrayList();
        File phase;
        if (phaseCode == 1) {
            phase = new File("phase-1.txt");
        } else if (phaseCode == 2) {
            phase = new File("phase-2.txt");
        } else {
            return null;
        }

        Scanner scanner = new Scanner(phase);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Item item = new Item();
            item.name = line.substring(0,line.indexOf("="));
            item.weight = Integer.valueOf(line.substring(line.indexOf("=")+1, line.length()));
            items.add(item);
        }
        return items;
    }

    /* loadU1: takes the ArrayList of Items returned from loadItems and starts creating U1 rockets */
    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> U1s = new ArrayList();
        Collections.sort(items);
        //System.out.println(totalWeight);
        //System.out.println(items.size());
        int loadedAmount=0;
        while (loadedAmount<items.size()) {
            U1 u1 = new U1();
            for (Item item : items) {
                if (item.getLoaded()==false) {
                    if (u1.isFull()) continue;
                    if (u1.canCarry(item)) {
                        u1.carry(item);
                        loadedAmount++;
                    }
                }
            }
            U1s.add(u1);
        }
        return U1s;
    }

    /* loadU2: takes the ArrayList of Items returned from loadItems and starts creating U2 rockets */
    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> U2s = new ArrayList();
        Collections.sort(items);
        int totalWeight = 0;
        for (Item item: items) {
            totalWeight += item.weight;
        }
        int currentWeight = 0;
        while (currentWeight<totalWeight) {
            U2 u2 = new U2();
            for (Item item : items) {
                if (item.getLoaded()==false) {
                    //System.out.println("item.weight="+item.weight);
                    if (u2.isFull()) continue;
                    //System.out.println(item.name+" = "+item.weight);
                    if (u2.canCarry(item)) {
                        //System.out.println("cancarry!");
                        u2.carry(item);
                        currentWeight+=item.weight;
                    }
                    //System.out.println("currentWeight="+currentWeight);
                }
            }
            U2s.add(u2);
        }
        return U2s;
    }

    public int runSimulation(ArrayList rockets) {
        int budget=0;
        int rocketCount=0;
        int cost=0;
        int cnt=0;
        for (Object rocketObj: rockets) {
            Rocket rocket = (Rocket) rocketObj;
           // System.out.println(rocket.cargoCarried);
            cost = rocket.cost;
            while (rocket.operationSucceed==false) {
                while (rocket.launchSucceed==false) {
                    rocketCount++;
                    rocket.launchSucceed = rocket.launch(rocket.cargoCarried);
                    //System.out.println("rocket.launchSucceed="+rocket.launchSucceed);
                }
                while (rocket.launchSucceed && rocket.landSucceed==false) {
                    rocket.landSucceed = rocket.land(rocket.cargoCarried);
                    //System.out.println("rocket.landSucceed="+rocket.landSucceed);
                    if (rocket.landSucceed==true) {
                        rocket.operationSucceed = true;
                    } else {
                        rocket.launchSucceed=false;
                    }
                }
                //System.out.println("rocket.operationSucceed="+rocket.operationSucceed);
                //System.out.println("rocketCount="+rocketCount);
            }
            cnt++;
        }
        budget = rocketCount * cost;
        //System.out.println("cost="+cost);
        //System.out.println("budget="+budget);
        return budget;
    }
}
