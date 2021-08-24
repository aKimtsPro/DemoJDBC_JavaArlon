import data_access.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        System.out.println("Trying the connection");
        try ( Connection connection = ConnectionFactory.getConnection() ) {
            System.out.println("connection success");

        }
        catch (SQLException ex){
            System.out.println("connection failed");
            System.out.println("PROBLEM: " + ex.getMessage());
        }


    }

}
