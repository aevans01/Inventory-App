
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author EXAEVAN1
 */
public class LoginDriver {

    public ArrayList login(String username, String password) {
        ArrayList<User> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from login;";
        String user = "Austin";
        String pass = "Eliza2018";
        String url = "jdbc:mysql://172.28.215.131:3306/login";

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt("LoginID"));
                    u.setFirstName(rs.getString("FirstName"));
                    u.setLastName(rs.getString("LastName"));
                    u.setUserName(rs.getString("Username"));
                    u.setPassword(rs.getString("Password"));
                    list.add(u);

                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
        return list;
    }
}
