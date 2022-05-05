
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author EXAEVAN1
 */
public class DBstuff {

    String user = "";
    String pass = "";
    String url = "jdbc:mysql://172.28.215.131:3306/login";

    public ArrayList browse() {
        ArrayList<Item> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from inventory";

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Item i = new Item();
                    i.setId(rs.getInt("ItemID"));
                    i.setName(rs.getString("ItemName"));
                    i.setUpc(rs.getString("UPC"));
                    i.setNumInStock(rs.getInt("NumberInStock"));
                    i.setReorderAmount(rs.getInt("ReorderAmount"));
                    list.add(i);

                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList search(String s) {
        ArrayList<Item> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from inventory where upper(ItemName) like upper(concat('%',?,'%'))";

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Item i = new Item();
                    i.setId(rs.getInt("ItemID"));
                    i.setName(rs.getString("ItemName"));
                    i.setUpc(rs.getString("UPC"));
                    i.setNumInStock(rs.getInt("NumberInStock"));
                    i.setReorderAmount(rs.getInt("ReorderAmount"));
                    list.add(i);

                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList searchUPC(String s) {
        ArrayList<Item> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from inventory where UPC = ?";

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Item i = new Item();
                    i.setId(rs.getInt("ItemID"));
                    i.setName(rs.getString("ItemName"));
                    i.setUpc(rs.getString("UPC"));
                    i.setNumInStock(rs.getInt("NumberInStock"));
                    i.setReorderAmount(rs.getInt("ReorderAmount"));
                    list.add(i);

                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
        return list;
    }

    public void subtractQty(int a, String b) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "update inventory set NumberInStock = ? where UPC = ?";

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, a);
            pstmt.setString(2, b);
            int rowAffected = pstmt.executeUpdate();
            System.out.println("rows affected: " + rowAffected);
            //pstmt.executeUpdate(sql);
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void addQty(int a, int b, String c) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "update inventory set NumberInStock = ?, reorderAmount = ? where UPC = ?";

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, a);
            pstmt.setInt(2, b);
            pstmt.setString(3, c);
            int rowAffected = pstmt.executeUpdate();
            System.out.println("rows affected: " + rowAffected);
            //pstmt.executeUpdate(sql);
            pstmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Item Has Been Updated! ", "", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Updating Item ", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addItems(String name, String upc, String numInStock, String reorderAmt) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "insert into inventory(ItemID,ItemName,UPC,NumberInStock,ReorderAmount) values(default,?,?,?,?)";

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, upc);
            pstmt.setInt(3, Integer.parseInt(numInStock));
            pstmt.setInt(4, Integer.parseInt(reorderAmt));

            pstmt.execute();
            pstmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, name + "Added To Database ", "", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Adding Item", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList listItems() {
        ArrayList<String> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from inventory";

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Item i = new Item();
                    i.setId(rs.getInt("ItemID"));
                    i.setName(rs.getString("ItemName"));
                    i.setUpc(rs.getString("UPC"));
                    i.setNumInStock(rs.getInt("NumberInStock"));
                    i.setReorderAmount(rs.getInt("ReorderAmount"));
                    list.add(i.getName());

                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
        return list;
    }

    public void removeItem(String upc) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "Delete from inventory where UPC = ?";

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, upc);

            pstmt.execute();
            pstmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Item Has Been Removed! ", "", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error Adding Item", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
