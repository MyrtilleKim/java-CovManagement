package com.kina.service;

import com.kina.model.Pack;
import com.kina.model.PackDetail;
import com.kina.model.Product;
import com.kina.sql.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackService {

    public static List<Pack> getAllPack() {
        List<Pack> res = new ArrayList<Pack>();
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        String sql = "SELECT * FROM PACK";

        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Pack rec = new Pack();

                rec.setId(rs.getString("PackID"));
                rec.setName(rs.getString("PackName"));
                rec.setPrice(rs.getInt("Price"));
                rec.setLimitQuantity(rs.getInt("LimitedQuantity"));
                rec.setDateExp(rs.getDate("columnIndex"));

                // private List<PackDetail> proList;
                List<PackDetail> packDetailList = getAllPackDetail(rec.getId());
                rec.setProList(packDetailList);

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

    public static Boolean delOne(Pack ele) {
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        String query = "delete from Pack where PackID = ?";
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

    public static PackDetail getByID(String id) {
        PackDetail res = null;
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "SELECT * FROM PACKDETAIL WHERE PackID = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = new PackDetail();

                Product prod = ProductService.getByID(rs.getString("ProductID"));
                res.setProduct(prod);
                res.setQuantity(rs.getInt("Quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<PackDetail> getAllPackDetail(String id) {
        List<PackDetail> res = new ArrayList<PackDetail>();
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "SELECT * FROM PACKDETAIL WHERE PackID = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PackDetail rec = new PackDetail();
                Product prod = ProductService.getByID(rs.getString("ProductID"));
                rec.setProduct(prod);
                rec.setQuantity(rs.getInt("Quantity"));
                res.add(rec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
