public class U1 extends Rocket {

    // Constructors
    U1() {
        this.cost = 100; // Million
        this.weight = 10; // tonnes
        this.maxWeight = 18; // tonnes
        this.paraChanceOfLaunchExplosion = 0.05;
        this.paraChanceOfLandingCrash = 0.01;
        cargoLimit = this.maxWeight - this.weight; // tonnes
    }

    // Methods
    @Override
    public boolean launch(int cargoCarried) {
        double chanceOfLaunchExplosion = this.paraChanceOfLaunchExplosion * (cargoCarried/(cargoLimit*10));
        //System.out.println("chanceOfLaunchExplosion="+chanceOfLaunchExplosion);
        //System.out.println("cargoCarried="+cargoCarried);
        //System.out.println("cargoLimit="+cargoLimit);
        double result = 1+Math.random()*100;
        //System.out.println("result="+result);
        if (result > chanceOfLaunchExplosion) {
            return true;
        }
        return false;
    }

    @Override
    public boolean land(int cargoCarried) {
        double chanceOfLandingCrash = this.paraChanceOfLandingCrash * (cargoCarried/(cargoLimit*10));
        double result = 1+Math.random()*100;
        if (result > chanceOfLandingCrash) {
            return true;
        }
        return false;
    }
}
