import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java dbConnection Test by Bhavesh!");
        insertData();
//        deleteData();
        getData();

    }
    public static Connection getConnection(){
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "";
            forName(driver);
            Connection conn = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("DB is connected...");
            return conn;

        } catch (Exception e) {
            System.out.println("got a new Error " + e);
        }
        return null;

    }

    public static void getData(){
        try{
            Statement state = getConnection().createStatement();
            ResultSet result = state.executeQuery("select * from user");
            while(result.next()){
                System.out.println(result.getString("name"));
                System.out.println(result.getString("email"));
            }
        } catch (Exception e) {
            System.out.println("Got an error "+ e);
        }
    };
    public static void insertData(){
        try{
            Statement state = getConnection().createStatement();
            int result = state.executeUpdate("insert into user (id,name,email) values (2,'Punit','punit@gmail.com')");
            if(result==1){
                System.out.println("Value added Successfully");
            }else{
                System.out.println("Got Some Error");
            }

        } catch (Exception e) {
            System.out.println("Got an error "+ e);
        }
    }

    public static void deleteData(){
        try{
            Statement state = getConnection().createStatement();
            int result = state.executeUpdate("delete from user where id=2");
            if(result==1){
                System.out.println("Value Deleted Successfully");
            }else{
                System.out.println("Got Some Error");
            }

        } catch (Exception e) {
            System.out.println("Got an error "+ e);
        }
    }


}
