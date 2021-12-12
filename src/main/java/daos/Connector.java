package daos;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Connector {

    public Car getCar(int id) {
            Connection connection = ConnectionFactory.getConnection();
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE id=" + id);

                if(rs.next())
                {
                    return extractCarFromResultSet(rs);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return null;
        }
    private Car extractCarFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();

        car.setId( rs.getInt("id") );
        car.setMake( rs.getString("make") );
        car.setModel( rs.getString("model") );
        car.setYear( rs.getInt("year") );
        car.setColor( rs.getString("color") );
        car.setVin( rs.getString("vin") );
        return car;
    }
    public Car getCarByMakeAndModel(String make, String model) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection(); // change from connector to Connection Factory
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM car WHERE car=? AND model=?");
            ps.setString(1, make);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                return extractCarFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public Set getAllCars() {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");

            Set cars = new HashSet();

            while(rs.next())
            {
                Car car = extractCarFromResultSet(rs);
                cars.add(car);
            }

            return cars;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public boolean insertCar(Car car) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES (NULL, ?, ?, ?)");
            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setString(5, car.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean updateCar(Car car) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET make=?, model=?, year=?, color=?, vin=?, WHERE id=?");
            ps.setString(1,  car.getMake());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setString(5, car.getVin());
            ps.setString(6, car.getColor());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean deleteCar(int id) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM car WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    private Connection getConnection() {
        return null;
    }

}
