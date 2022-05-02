package com.kina.service;

import com.kina.model.Location;
import com.kina.model.TreatmentRecord;
import com.kina.model.User;
import static com.kina.service.UserService.getAllRelatedUser;
import static com.kina.service.UserService.getTreatmentRecord;
import com.kina.sql.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationService {
    public static Location getByID(String id){
        Location location = null;
        connectDB cn = new connectDB();
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = cn.getConnection();
            String query = "EXEC proc_GetAddress ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                location = new Location(id, rs.getString("AddressName"),rs.getString("WardName"), rs.getString("DistrictName"), rs.getString("CityName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }
    
    public static List<String> getAllCity() {
        List<String> res = new ArrayList<String>();
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = cn.getConnection();
            String sql = "SELECT * FROM CITY";
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rec = rs.getString("CityName");
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
    
    public static List<String> getAllDistrict() {
        List<String> res = new ArrayList<String>();
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = cn.getConnection();
            String sql = "SELECT * FROM DISTRICT";
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rec = rs.getString("DistrictName");
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
    
    public static List<String> getAllWard() {
        List<String> res = new ArrayList<String>();
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = cn.getConnection();
            String sql = "SELECT * FROM Ward";
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rec = rs.getString("WardName");
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