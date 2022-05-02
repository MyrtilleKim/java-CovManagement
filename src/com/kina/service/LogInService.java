package com.kina.service;

import com.kina.model.Account;
import com.kina.model.LogIn;
import com.kina.model.Product;
import com.kina.sql.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogInService {
    public static List<LogIn> getAll(String id) {
        List<LogIn> res = new ArrayList<LogIn>();
        connectDB cn = new connectDB();
        Connection connection = cn.getConnection();
        PreparedStatement ps = null;
        
        try {
            String sql = "SELECT * FROM LOGINRECORD WHERE AccountID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LogIn rec = new LogIn();
                
                rec.setId(rs.getString("LogRecID"));
                rec.setTime(rs.getTimestamp("LogTimestamp"));
             
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
}
