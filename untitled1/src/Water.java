public class Water {
    private String name;
    private int volume;
    private boolean isMineral;
    int idCoffeUsed;
    public Water(String name, int volume,boolean isMineral) {
        this.name = name;
        this.volume = volume;
        this.isMineral=isMineral;
    }


    public String getName() {
        return name;
    }

    public boolean isMineral() {
        return isMineral;
    }

    public void setMineral(boolean mineral) {
        isMineral = mineral;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getVolume() {
        return volume;
    }


    public void setVolume(int volume) {
        this.volume = volume;
    }


}
