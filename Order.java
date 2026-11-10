
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
    }

    public void addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Invalid item!");
            return;
        }

        if (itemCount >= 3) {
            System.out.println("Order can only contain 3 items!");
            return;
        }

        if (itemCount == 0) {
            item1 = item;
        } else if (itemCount == 1) {
            item2 = item;
        } else {
            item3 = item;
        }

        itemCount++;
        System.out.println(item.getName() + " added to order.");
    }

    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    public double computeTotal() {
        double total = computeSubtotal();

        if (customer.isStudent()) {
            total -= total * 0.10;
        }

        return total;
    }

    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;

        return Math.max(total, 0);
    }

    public void printReceipt() {
        System.out.println("\n================================");
        System.out.println("       CAMPUS CAFE RECEIPT");
        System.out.println("================================");

        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());

        System.out.println("--------------------------------");

        if (item1 != null) {
            System.out.printf("%-20s PHP %.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("%-20s PHP %.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("%-20s PHP %.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        double subtotal = computeSubtotal();
        double discount = customer.isStudent() ? subtotal * 0.10 : 0;

        System.out.println("--------------------------------");
        System.out.printf("Subtotal: PHP %.2f%n", subtotal);
        System.out.printf("Student Discount: PHP %.2f%n", discount);
        System.out.printf("Total: PHP %.2f%n", computeTotal());

        customer.addPoints(computeTotal());

        System.out.println("Loyalty Points: " + customer.getLoyaltyPoints());
        System.out.println("================================");
    }
}
