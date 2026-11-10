
public class Pastry extends MenuItem {

    private boolean heated;

    public Pastry() {
        super();
        heated = false;
    }

    public Pastry(String name, double basePrice, String itemCode, boolean heated) {
        super(name, basePrice, itemCode);
        this.heated = heated;
    }

    public boolean isHeated() {
        return heated;
    }

    public void setHeated(boolean heated) {
        this.heated = heated;
    }

    @Override
    public double computePrice() {
        if (heated) {
            return basePrice + 10;
        }
        return basePrice;
    }

    @Override
    public String getDescription() {
        if (heated) {
            return name + " (Heated)";
        }
        return name;
    }
}
