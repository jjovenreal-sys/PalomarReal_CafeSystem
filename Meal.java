public class Meal extends MenuItem {

    private boolean combo;
    private int extraSides;

    public Meal() {
        super();
        combo = false;
        extraSides = 0;
    }

    public Meal(String name, double basePrice, String itemCode,
                boolean combo, int extraSides) {
        super(name, basePrice, itemCode);
        this.combo = combo;
        setExtraSides(extraSides);
    }

    public boolean isCombo() {
        return combo;
    }

    public void setCombo(boolean combo) {
        this.combo = combo;
    }

    public int getExtraSides() {
        return extraSides;
    }

    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Extra sides cannot be negative!");
        }
    }

    @Override
    public double computePrice() {
        double price = basePrice;

        if (combo) {
            price += 30;
        }

        price += extraSides * 15;

        return price;
    }

    @Override
    public String getDescription() {
        return name + (combo ? " (Combo)" : "");
    }
}

