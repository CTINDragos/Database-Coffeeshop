public class water_distribuitors {
    private int id;
    private String name;
    private int waterId; // Foreign key to water table

    public water_distribuitors(int id, String name, int waterId) {
        this.id = id;
        this.name = name;
        this.waterId = waterId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWaterId() {
        return waterId;
    }

    public void setWaterId(int waterId) {
        this.waterId = waterId;
    }

}
