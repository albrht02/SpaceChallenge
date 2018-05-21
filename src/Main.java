import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Simulation sim = new Simulation();

        ArrayList<Item> items1 = sim.loadItems(1);
        ArrayList<Item> items2 = sim.loadItems(2);

        ArrayList<U1> u1_p1 = sim.loadU1(items1);
        ArrayList<U1> u1_p2 = sim.loadU1(items2);

        for (Item i: items1) i.setLoaded(false);
        for (Item i: items2) i.setLoaded(false);

        ArrayList<U2> u2_p1 = sim.loadU2(items1);
        ArrayList<U2> u2_p2 = sim.loadU2(items2);

        int budget_u1_p1 = sim.runSimulation(u1_p1);
        int budget_u1_p2 = sim.runSimulation(u1_p2);
        int budget_u2_p1 = sim.runSimulation(u2_p1);
        int budget_u2_p2 = sim.runSimulation(u2_p2);

        int budgetU1 = budget_u1_p1 + budget_u1_p2;
        int budgetU2 = budget_u2_p1 + budget_u2_p2;

        System.out.println("Budget of Using U1 for the operation: "+budgetU1+" ("+budget_u1_p1+"+"+budget_u1_p2+") Million");
        System.out.println("Budget of Using U2 for the operation: "+budgetU2+" ("+budget_u2_p1+"+"+budget_u2_p2+") Million");
    }
}
