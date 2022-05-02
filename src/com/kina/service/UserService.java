package com.kina.service;

import com.kina.model.TreatmentRecord;
import com.kina.model.User;
import com.kina.sql.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static Boolean UpdStatus(User user) {
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = cn.getConnection();
            String query = "update USERS set UserStatus = ? where UserID = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, user.getStatus());
            ps.setString(2, user.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean UpdTreatmentLocation(User user) {
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = cn.getConnection();
            String query = "update STUDENT set TrmtLocaID = ? where UserID = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getTrmtLoca().getId());
            ps.setString(2, user.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<TreatmentRecord> getTreatmentRecord(String id) {
        List<TreatmentRecord> res = new ArrayList<TreatmentRecord>();
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = cn.getConnection();
            String sql = "SELECT * FROM TREATMENTRECORD WHERE UserID = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TreatmentRecord rec = new TreatmentRecord();
                rec.setTrmtLoca(TreatmentLocationService.getByID(rs.getString("TrmtLocaID")));
                rec.setStatus(rs.getInt("UserStatus"));
                rec.setRecTimestamp(rs.getTimestamp("RecordTimestamp"));
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

    public static List<User> getAllRelatedUser(String id) {
        List<User> res = new ArrayList<User>();
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = cn.getConnection();
            String sql = "SELECT * FROM RELATED WHERE UserID_1 = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User rec = new User();
                rec = getUserById(rs.getString("UserID_2"));
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

    public static List<User> getAllUser() {
        List<User> res = new ArrayList<User>();
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = cn.getConnection();
            String sql = "SELECT * FROM USERS";
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User rec = new User();
                rec.setId(rs.getString("UserID"));
                rec.setName(rs.getString("Username"));
                rec.setNoID(rs.getString("NoID"));
                rec.setBirthYear(rs.getInt("BirthYear"));
                rec.setAddress(LocationService.getByID(rs.getString("AddressID")));
                rec.setTrmtLoca(TreatmentLocationService.getByID(rs.getString("TrmtLocaID")));
                rec.setDebit(rs.getInt("DebitBalance"));
                rec.setStatus(rs.getInt("UserStatus"));

                // list related List
                List<User> relatedUserList = getAllRelatedUser(rec.getId());
                rec.setRelatedList(relatedUserList);
                // list treatment record
                List<TreatmentRecord> trmRecList = getTreatmentRecord(rec.getId());
                rec.setTrmtRec(trmRecList);
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

    public static String getUserID(String id) {
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;
        String result = null;

        try {
            connection = cn.getConnection();
            String sql = "SELECT * FROM USERS where NoID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("UserID");
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
        return result;
    }
    
    public static Boolean addOne(User user) {
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "insert into USER values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getNoID());
            ps.setInt(4, user.getBirthYear());
            ps.setString(5, user.getAddress().getId());
            ps.setString(6, user.getTrmtLoca().getId());
            ps.setInt(7, user.getStatus());
            ps.setInt(8, user.getDebit());
            ps.executeQuery();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static User getUserById(String id) {
        connectDB cn = new connectDB();
        Connection connection = null;
        PreparedStatement ps = null;
        User rec = new User();

        try {
            connection = cn.getConnection();
            String sql = "SELECT * FROM USERS where UserID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {     
                rec.setId(rs.getString("UserID"));
                rec.setName(rs.getString("Username"));
                rec.setNoID(rs.getString("NoID"));
                rec.setBirthYear(rs.getInt("BirthYear"));
                rec.setAddress(LocationService.getByID(rs.getString("AddressID")));
                rec.setTrmtLoca(TreatmentLocationService.getByID(rs.getString("TrmtLocaID")));
                rec.setDebit(rs.getInt("DebitBalance"));
                rec.setStatus(rs.getInt("UserStatus"));

                // list related List
                List<User> relatedUserList = getAllRelatedUser(rec.getId());
                rec.setRelatedList(relatedUserList);
                // list treatment record
                List<TreatmentRecord> trmRecList = getTreatmentRecord(rec.getId());
                rec.setTrmtRec(trmRecList);
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
        return rec;
    }
}
