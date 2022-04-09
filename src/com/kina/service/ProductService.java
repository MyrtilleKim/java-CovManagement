package com.kina.service;

import com.kina.model.Product;
import com.kina.sql.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public static Product getByID(String id) {
        Product res = null;
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "SELECT * FROM PRODUCT WHERE ProductID = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = new Product();
                res.setId(rs.getString("ProductID"));
                res.setName(rs.getString("ProductName"));
                res.setUnit(rs.getString("Unit"));
                res.setPrice(rs.getInt("Price"));
                res.setImage(rs.getString("ProductImage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<Product> getAllProduct() {
        List<Product> res = new ArrayList<Product>();
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        

        try {
            String sql = "SELECT * FROM PRODUCT";
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product rec = new Product();

                rec.setId(rs.getString("ProductID"));
                rec.setName(rs.getString("ProductName"));
                rec.setUnit(rs.getString("Unit"));
                rec.setPrice(rs.getInt("Price"));
                rec.setImage(rs.getString("ProductImage"));

                res.add(rec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return res;
    }

    public static Boolean addOne(Product ele) {
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        String query = "insert into Product values(?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ele.getId());
            ps.setString(2, ele.getName());
            ps.setString(3, ele.getUnit());
            ps.setInt(4, ele.getPrice());
            // ps.setImage(5, );
            ps.executeQuery();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean updOne(Product ele) {
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "update Product set ";
            ps = connection.prepareStatement(query);
            ps.setString(1, ele.getId());
            ps.setString(2, ele.getName());
            ps.setString(3, ele.getUnit());
            ps.setInt(4, ele.getPrice());
            // ps.setImage(5, );
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean delOne(Product ele) {
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        String query = "delete from Product where ProductID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ele.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
