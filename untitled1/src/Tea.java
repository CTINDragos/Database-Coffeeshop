public class Tea {
    private String name;
    private String type;
    private int brewingTime;


    public Tea(String name, String type, int brewingTime) {
        this.name = name;
        this.type = type;
        this.brewingTime = brewingTime;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getBrewingTime() {
        return brewingTime;
    }

    public void setBrewingTime(int brewingTime) {
        this.brewingTime = brewingTime;
    }
}
