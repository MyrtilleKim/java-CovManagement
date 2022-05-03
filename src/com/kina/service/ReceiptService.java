/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kina.service;

import com.kina.model.Pack;
import com.kina.model.PackDetail;
import com.kina.model.Receipt;
import com.kina.model.ReceiptDetail;
import com.kina.sql.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ReceiptService {

    public static int getTotalByID(String id) {
        int total = 0;
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        String query = "EXEC usp_Total ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("tongtien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public static int countRecepit() {
        int res = 0;
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = cn.getConnection();
            String sql = "SELECT COUNT(*) FROM RECEIPT";
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getInt(1);
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

    public static boolean addReceipt(Receipt receipt) {
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;

        try {
            String query = "insert into RECEIPT values(?, ?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, receipt.getId());
            ps.setString(2, receipt.getUserID());
            ps.setDate(3, receipt.getOrderDate());
            ps.setBoolean(4, receipt.getStatus());

            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void addReceiptDetail(String id, ReceiptDetail rcDetail) {
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;

        try {
            String query = "insert into RECEIPT_DETAIL values(?, ?, ?)";
            ps = connection.prepareStatement(query);

            ps.setString(1, id);
            ps.setString(2, rcDetail.getPack().getId());
            ps.setInt(3, rcDetail.getQuantity());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
