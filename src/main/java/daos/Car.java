package daos;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Car {

    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private String vin;


    public Car() {
    }

    public Car(String make, String model, Integer year, String color, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }
    //It's good practice to provide default empty constructor, a full constructor and a
    // full constructor without the id parameter.

    public Car(Integer id, String make, String model, Integer year, String color, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
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






    private void add(Car car) {
    }

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

}

