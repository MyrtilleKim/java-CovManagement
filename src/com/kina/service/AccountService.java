/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kina.service;

import com.kina.model.Account;
import com.kina.model.Product;
import com.kina.sql.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AccountService {
    
    public static List<Account> getAllAccount() {
        List<Account> res = new ArrayList<Account>();
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM ACCOUNT";
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account rec = new Account();

                rec.setId(rs.getString("NoID"));
                rec.setPass(rs.getString("Pass"));
                rec.setRoles(rs.getInt("Roles"));
                
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
    
    public static Account getById(String id) {
        Account res = null;
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "SELECT * FROM ACCOUNT WHERE NoID = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = new Account();
                res.setId(rs.getString("NoID"));
                res.setPass(rs.getString("Pass"));
                res.setRoles(rs.getInt("Roles"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
