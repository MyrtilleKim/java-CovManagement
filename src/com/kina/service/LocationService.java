package com.kina.service;

import com.kina.model.Location;
import com.kina.sql.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}