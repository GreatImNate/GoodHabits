package ndseeg.goodhabits.profile;



public abstract class Item {
    String name;
    String description;

    // For GHs values will be 1-5 or some number that doing the habit will give
    // For Goals the value will represent the points that you need to accumulate to
    int value;

    public void setName(String name) {
        this.name = name;
    }
}
