public class U2 extends Rocket {
    // Constructors
    U2() {
        this.cost = 120;
        this.weight = 18;
        this.maxWeight = 29;
        this.paraChanceOfLaunchExplosion = 0.04;
        this.paraChanceOfLandingCrash = 0.08;
        cargoLimit = this.maxWeight - this.weight;
    }

    // Methods
    @Override
    public boolean launch(int cargoCarried) {
        double chanceOfLaunchExplosion = this.paraChanceOfLaunchExplosion * (cargoCarried/(cargoLimit*10));
        double result = 1+Math.random()*100;
        if (result > chanceOfLaunchExplosion) {
            return true;
        }
        return false;
    }

    @Override
    public boolean land(int cargoCarried) {
        double chanceOfLandingCrash = this.paraChanceOfLandingCrash * (cargoCarried/(cargoLimit*10));
        //System.out.println("chanceOfLaunchExplosion="+chanceOfLandingCrash);
        double result = 1+Math.random()*100;
        //System.out.println("result="+result);
        if (result > chanceOfLandingCrash) {
            return true;
        }
        return false;
    }
}
