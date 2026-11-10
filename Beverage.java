
public class Beverage extends MenuItem {

    private String size;


    public Beverage() {
        super();
        this.size = "S";
    }


    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }


    @Override
    public double computePrice() {
        // Large adds 25 pesos.
        if (size.equals("L")) {
            return basePrice + 25;
        }
        // Medium adds 15 pesos.
        else if (size.equals("M")) {
            return basePrice + 15;
        }
        // Small uses the base price.
        else {
            return basePrice;
        }
    }


    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }


    public String getSize() {
        return size;
    }


    public void setSize(String size) {
        // Accept only S, M, or L.
        if (size != null && (size.equals("S") ||
                size.equals("M") || size.equals("L"))) {
            this.size = size;
        } else {
            System.out.println("Invalid beverage size!");
        }
    }
}
