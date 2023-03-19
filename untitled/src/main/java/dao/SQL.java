package dao;

public class SQL implements  IDao {
    @Override
    public double getData() {
        System.out.println("From SQL DB");
        return (7);
    }
}
