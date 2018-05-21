public class Rocket implements SpaceShip {
    // Fields
    public int cost; // Million
    public int weight; // Tonnes
    public int cargoCarried; // kg
    public int cargoLimit;
    public int maxWeight; // Tonnes
    public double paraChanceOfLaunchExplosion;
    public double paraChanceOfLandingCrash;
    public boolean launchSucceed = false; // if launch successes, turn true
    public boolean landSucceed = false; // if land successes, turn true
    public boolean operationSucceed = false;

    // Constructors
    Rocket() {
       super();
    }
    Rocket(int cost, int weight, int maxWeight,
           double paraChanceOfLaunchExplosion, double paraChanceOfLandingCrash) {
        this.cost = cost;
        this.weight = weight;
        this.cargoCarried = 0;
        this.maxWeight = maxWeight;
        this.paraChanceOfLaunchExplosion = paraChanceOfLaunchExplosion;
        this.paraChanceOfLandingCrash = paraChanceOfLandingCrash;
    }

    @Override
    public boolean launch(int cargoCarried) {
        return true;
    }

    @Override
    public boolean land(int cargoCarried) {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (item.weight+this.weight*1000+this.cargoCarried <= maxWeight*1000) {
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item item) {
        item.setLoaded(true);
        this.cargoCarried += item.weight;
    }

    public boolean isFull(){
        if (this.cargoCarried==(this.maxWeight-this.weight)*1000) return true;
        return false;
    }
}
