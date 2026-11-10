
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() {
        this.name = "Unknown Customer";
        this.student = false;
        this.loyaltyPoints = 0;
    }

    public Customer(String name) {
        this.name = name;
        this.student = false;
        this.loyaltyPoints = 0;
    }

    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) {
            loyaltyPoints += (int) (amountSpent / 50);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid customer name!");
        }
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Loyalty points cannot be negative!");
        }
    }
}

