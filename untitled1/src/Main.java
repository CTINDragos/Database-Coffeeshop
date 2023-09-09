import java.sql.*;

public class Main {
    static ConnectionUtil db = new ConnectionUtil();

    public static void main(String[] args) {
        db.connect_to_db("postgres", "postgres", "Asdqwe11");


        createCoffee("Espresso", "Strong");
        readCoffee(2);
        updateCoffee(2, "Latte", "Mild");
        deleteCoffee(2);

        createPastry("Croissant", "Sweet");
        readPastry(2);
        updatePastry(2, "Danish", "Sweet");
        deletePastry(2);

        createTea("Green Tea", "Green", 3);
        readTea(2);
        updateTea(2, "Black Tea", "Black", 4);
        deleteTea(2);

        createMilk("Whole Milk", 250, true, 2);
        readMilk(2);
        updateMilk(2, "Skim Milk", 300, false, 1);
        deleteMilk(2);

        createWater("Mineral Water", 500, true, 2);
        readWater(2);
        updateWater(2, "Spring Water", 750, false, 2);
        deleteWater(2);

        createPromotion(1, 1, 5, 10);
        readPromotion(1, 1);
        updatePromotion(1, 1, 7, 12);
        deletePromotion(1, 1);

        createWaterDistributor("Distributor 1", 2);
        readWaterDistributor(1);
        updateWaterDistributor(1, "Distributor 2", 2);
        deleteWaterDistributor(1);

        db.closeConnection();
    }
    public static void createPromotion(int pastryId, int coffeeId, int numberOfPastries, int numberOfCoffees) {
            try {
                PreparedStatement statement = db.getConnection().prepareStatement(
                        "INSERT INTO coffeshop.PastryAndCoffeePromotion (pastry_id, coffee_id, NumberOfPastries, NumberOfCoffees) " +
                                "VALUES (?, ?, ?, ?)"
                );

                statement.setInt(1, pastryId);
                statement.setInt(2, coffeeId);
                statement.setInt(3, numberOfPastries);
                statement.setInt(4, numberOfCoffees);

                statement.executeUpdate();
                System.out.println("Promotion added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void readPromotion(int pastryId, int coffeeId) {
            try {
                PreparedStatement statement = db.getConnection().prepareStatement(
                        "SELECT * FROM coffeshop.PastryAndCoffeePromotion WHERE pastry_id = ? AND coffee_id = ?"
                );

                statement.setInt(1, pastryId);
                statement.setInt(2, coffeeId);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int numberOfPastries = resultSet.getInt("NumberOfPastries");
                    int numberOfCoffees = resultSet.getInt("NumberOfCoffees");

                    System.out.println("Number of Pastries: " + numberOfPastries + ", Number of Coffees: " + numberOfCoffees);
                } else {
                    System.out.println("Promotion not found for given pastry and coffee IDs.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void updatePromotion(int pastryId, int coffeeId, int newNumberOfPastries, int newNumberOfCoffees) {
            try {
                PreparedStatement statement = db.getConnection().prepareStatement(
                        "UPDATE coffeshop.PastryAndCoffeePromotion SET NumberOfPastries = ?, NumberOfCoffees = ? " +
                                "WHERE pastry_id = ? AND coffee_id = ?"
                );

                statement.setInt(1, newNumberOfPastries);
                statement.setInt(2, newNumberOfCoffees);
                statement.setInt(3, pastryId);
                statement.setInt(4, coffeeId);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Promotion updated successfully.");
                } else {
                    System.out.println("Promotion not found for given pastry and coffee IDs.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void deletePromotion(int pastryId, int coffeeId) {
            try {
                PreparedStatement statement = db.getConnection().prepareStatement(
                        "DELETE FROM coffeshop.PastryAndCoffeePromotion WHERE pastry_id = ? AND coffee_id = ?"
                );

                statement.setInt(1, pastryId);
                statement.setInt(2, coffeeId);

                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Promotion deleted successfully.");
                } else {
                    System.out.println("Promotion not found for given pastry and coffee IDs.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public static void createWaterDistributor(String name, int waterId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "INSERT INTO coffeshop.water_distributors (name, water_id) VALUES (?, ?)"
            );

            statement.setString(1, name);
            statement.setInt(2, waterId);

            statement.executeUpdate();
            System.out.println("Water Distributor added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readWaterDistributor(int distributorId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "SELECT * FROM coffeshop.water_distributors WHERE id = ?"
            );

            statement.setInt(1, distributorId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int waterId = resultSet.getInt("water_id");

                System.out.println("Name: " + name + ", Water ID: " + waterId);
            } else {
                System.out.println("Water Distributor with ID " + distributorId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateWaterDistributor(int distributorId, String newName, int newWaterId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "UPDATE coffeshop.water_distributors SET name = ?, water_id = ? WHERE id = ?"
            );

            statement.setString(1, newName);
            statement.setInt(2, newWaterId);
            statement.setInt(3, distributorId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Water Distributor updated successfully.");
            } else {
                System.out.println("Water Distributor with ID " + distributorId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteWaterDistributor(int distributorId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "DELETE FROM coffeshop.water_distributors WHERE id = ?"
            );

            statement.setInt(1, distributorId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Water Distributor deleted successfully.");
            } else {
                System.out.println("Water Distributor with ID " + distributorId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createWater(String name, int volume, boolean isMineral,int coffeeisusedfor) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "INSERT INTO coffeshop.water (name, volume, is_mineral , id_coffee) VALUES (?, ?, ? , ?)"
            );

            statement.setString(1, name);
            statement.setInt(2, volume);
            statement.setBoolean(3, isMineral);
            statement.setInt(4,coffeeisusedfor);

            statement.executeUpdate();
            System.out.println("Water added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int getNonMineralWaterCount() {
        int nonMineralCount = -1; // Default value in case of an error

        try {
            CallableStatement statement = db.getConnection().prepareCall("{ ? = call count_non_mineral_waters() }");
            statement.registerOutParameter(1, Types.INTEGER);

            statement.execute();

            nonMineralCount = statement.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nonMineralCount;
    }
    public static int getMineralWaterCount() {
        int mineralCount = -1; // Default value in case of an error

        try {
            CallableStatement statement = db.getConnection().prepareCall("{ ? = call count_mineral_waters() }");
            statement.registerOutParameter(1, Types.INTEGER);

            statement.execute();

            mineralCount = statement.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mineralCount;
    }
    public static void readWater(int waterId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "SELECT * FROM coffeshop.Water WHERE id = ?"
            );

            statement.setInt(1, waterId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int volume = resultSet.getInt("volume");
                boolean isMineral = resultSet.getBoolean("is_mineral");
                int coffeusedfor=resultSet.getInt("id_coffee");
                System.out.println("Name: " + name + ", Volume: " + volume + " ml, Is Mineral: " + isMineral+coffeusedfor);
            } else {
                System.out.println("Water with ID " + waterId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateWater(int waterId, String newName, int newVolume, boolean newIsMineral,int idforcoffe) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "UPDATE coffeshop.water SET name = ?, volume = ?, is_mineral = ? , id_coffee= ? WHERE id = ?"
            );

            statement.setString(1, newName);
            statement.setInt(2, newVolume);
            statement.setBoolean(3, newIsMineral);
            statement.setInt(4, waterId);
            statement.setInt(5,idforcoffe);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Water updated successfully.");
            } else {
                System.out.println("Water with ID " + waterId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteWater(int waterId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "DELETE FROM coffeshop.Water WHERE id = ?"
            );

            statement.setInt(1, waterId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Water deleted successfully.");
            } else {
                System.out.println("Water with ID " + waterId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createTea(String name, String type, int brewingTime) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "INSERT INTO coffeshop.Tea (name, type, brewing_time) VALUES (?, ?, ?)"
            );

            statement.setString(1, name);
            statement.setString(2, type);
            statement.setInt(3, brewingTime);

            statement.executeUpdate();
            System.out.println("Tea added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readTea(int teaId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "SELECT * FROM coffeshop.Tea WHERE id = ?"
            );

            statement.setInt(1, teaId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int brewingTime = resultSet.getInt("brewing_time");

                System.out.println("Name: " + name + ", Type: " + type + ", Brewing Time: " + brewingTime + " minutes");
            } else {
                System.out.println("Tea with ID " + teaId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTea(int teaId, String newName, String newType, int newBrewingTime) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "UPDATE coffeshop.Tea SET name = ?, type = ?, brewing_time = ? WHERE id = ?"
            );

            statement.setString(1, newName);
            statement.setString(2, newType);
            statement.setInt(3, newBrewingTime);
            statement.setInt(4, teaId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Tea updated successfully.");
            } else {
                System.out.println("Tea with ID " + teaId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTea(int teaId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "DELETE FROM coffeshop.Tea WHERE id = ?"
            );

            statement.setInt(1, teaId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Tea deleted successfully.");
            } else {
                System.out.println("Tea with ID " + teaId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createMilk(String typeOfMilk, int volume, boolean hasSugarAdded, int useforcoffe) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "INSERT INTO coffeshop.milk (type_of_milk, volume, has_sugar_added, use_for_coffee) VALUES (?, ?, ?, ?)"
            );

            statement.setString(1, typeOfMilk);
            statement.setInt(2, volume);
            statement.setBoolean(3, hasSugarAdded);
            statement.setInt(4, useforcoffe);

            statement.executeUpdate();
            System.out.println("Milk added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readMilk(int milkId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "SELECT * FROM coffeshop.milk WHERE id = ?"
            );

            statement.setInt(1, milkId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String typeOfMilk = resultSet.getString("type_of_milk");
                int volume = resultSet.getInt("volume");
                boolean hasSugarAdded = resultSet.getBoolean("has_sugar_added");
                String useforcoffe = resultSet.getString("use_for_coffee");

                System.out.println("Type of Milk: " + typeOfMilk + ", Volume: " + volume +
                        ", Has Sugar Added: " + hasSugarAdded + ", Use for Coffee: " + useforcoffe);
            } else {
                System.out.println("Milk with ID " + milkId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateMilk( int milkId, String typeOfMilk, int volume, boolean hasSugarAdded, int useforcoffe) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "UPDATE coffeshop.milk SET type_of_milk = ?, volume = ?, has_sugar_added = ?, use_for_coffee = ? WHERE id = ?"
            );

            statement.setString(1, typeOfMilk);
            statement.setInt(2, volume);
            statement.setBoolean(3, hasSugarAdded);
            statement.setInt(4, useforcoffe);
            statement.setInt(5, milkId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Milk updated successfully.");
            } else {
                System.out.println("Milk with ID " + milkId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMilk(int milkId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "DELETE FROM coffeshop.milk WHERE id = ?"
            );

            statement.setInt(1, milkId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Milk deleted successfully.");
            } else {
                System.out.println("Milk with ID " + milkId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createCoffee(String name, String strength) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "INSERT INTO CoffeShop.coffee (name, strength) VALUES (?, ?)"
            );

            statement.setString(1, name);
            statement.setString(2, strength);

            statement.executeUpdate();
            System.out.println("Coffee added successfully.");
            System.out.println(name + ' ' + strength);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readCoffee(int coffeeId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "SELECT * FROM CoffeShop.coffee WHERE id = ?"
            );

            statement.setInt(1, coffeeId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String strength = resultSet.getString("strength");

                System.out.println("Name: " + name + ", Strength: " + strength);
            } else {
                System.out.println("Coffee with ID " + coffeeId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCoffee(int coffeeId, String newName, String newStrength) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "UPDATE CoffeShop.coffee SET name = ?, strength = ? WHERE id = ?"
            );

            statement.setString(1, newName);
            statement.setString(2, newStrength);
            statement.setInt(3, coffeeId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Coffee updated successfully.");
            } else {
                System.out.println("Coffee with ID " + coffeeId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCoffee(int coffeeId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "DELETE FROM CoffeShop.coffee WHERE id = ?"
            );

            statement.setInt(1, coffeeId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Coffee deleted successfully.");
            } else {
                System.out.println("Coffee with ID " + coffeeId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createPastry(String name, String type) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "INSERT INTO CoffeShop.pastry (name, type) VALUES (?, ?)"
            );

            statement.setString(1, name);
            statement.setString(2, type);

            statement.executeUpdate();
            System.out.println("Pastry added successfully.");
            System.out.println(name+' '+type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readPastry(int pastryId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "SELECT * FROM CoffeShop.pastry WHERE id = ?"
            );

            statement.setInt(1, pastryId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");

                System.out.println("Name: " + name + ", Type: " + type);
            } else {
                System.out.println("Pastry with ID " + pastryId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePastry(int pastryId, String newName, String newType) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "UPDATE CoffeShop.pastry SET name = ?, type = ? WHERE id = ?"
            );

            statement.setString(1, newName);
            statement.setString(2, newType);
            statement.setInt(3, pastryId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Pastry updated successfully.");
            } else {
                System.out.println("Pastry with ID " + pastryId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePastry(int pastryId) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "DELETE FROM CoffeShop.pastry WHERE id = ?"
            );

            statement.setInt(1, pastryId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Pastry deleted successfully.");
            } else {
                System.out.println("Pastry with ID " + pastryId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
