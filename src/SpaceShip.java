public interface SpaceShip {
    boolean launch(int cargoCarried);
    boolean land(int cargoCarried);
    boolean canCarry(Item item);
    void carry(Item item);
}
