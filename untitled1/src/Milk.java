import java.sql.*;

public class Milk {
    private String typeOfMilk;
    private int volume;
    private boolean hasSugarAdded;
    private String useforcoffe;

    public Milk(String typeOfMilk, int volume, boolean hasSugarAdded, String useforcoffe) {
        this.typeOfMilk = typeOfMilk;
        this.volume = volume;
        this.hasSugarAdded = hasSugarAdded;
        this.useforcoffe = useforcoffe;
    }

    // Getters and setters for typeOfMilk, volume, hasSugarAdded, and useforcoffe

    public String getTypeOfMilk() {
        return typeOfMilk;
    }

    public void setTypeOfMilk(String typeOfMilk) {
        this.typeOfMilk = typeOfMilk;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isHasSugarAdded() {
        return hasSugarAdded;
    }

    public void setHasSugarAdded(boolean hasSugarAdded) {
        this.hasSugarAdded = hasSugarAdded;
    }

    public String getUseforcoffe() {
        return useforcoffe;
    }

    public void setUseforcoffe(String useforcoffe) {
        this.useforcoffe = useforcoffe;
    }
}