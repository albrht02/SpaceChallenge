public class Item implements Comparable<Item> {
    // Fields
    String name;
    public int weight; // kg
    private boolean loaded;

    // Constructor
    Item() {
        loaded = false;
    }

    // Methods
    @Override
    public int compareTo(Item o) {
        // this will return a negative value if this < specified but will return a positive value if this > specified
        return o.weight - this.weight;
    }

    public void setLoaded(boolean b) {
        loaded = b;
    }
    public boolean getLoaded() {
        return loaded;
    }
}
