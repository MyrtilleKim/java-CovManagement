/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kina.service;

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
    public static int getTotalByID(String id){
        int total = 0;
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        String query = "EXEC usp_Total ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("tongtien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
}
