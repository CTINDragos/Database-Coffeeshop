public class PastryAndCoffeePromotion {
    private int pastryId;
    private int coffeeId;
    private int numberOfPastries;
    private int numberOfCoffees;

    public PastryAndCoffeePromotion(int pastryId, int coffeeId, int numberOfPastries, int numberOfCoffees) {
        this.pastryId = pastryId;
        this.coffeeId = coffeeId;
        this.numberOfPastries = numberOfPastries;
        this.numberOfCoffees = numberOfCoffees;
    }

    public int getPastryId() {
        return pastryId;
    }

    public void setPastryId(int pastryId) {
        this.pastryId = pastryId;
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public int getNumberOfPastries() {
        return numberOfPastries;
    }

    public void setNumberOfPastries(int numberOfPastries) {
        this.numberOfPastries = numberOfPastries;
    }

    public int getNumberOfCoffees() {
        return numberOfCoffees;
    }

    public void setNumberOfCoffees(int numberOfCoffees) {
        this.numberOfCoffees = numberOfCoffees;
    }
}
