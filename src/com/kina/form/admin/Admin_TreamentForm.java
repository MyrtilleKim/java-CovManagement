package com.kina.form.admin;

import com.kina.model.Location;
import com.kina.model.TreatmentLocation;
import com.kina.service.LocationService;
import com.kina.sql.connectDB;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin_TreamentForm extends javax.swing.JPanel {

    public Admin_TreamentForm() {
        initComponents();
        setOpaque(false);

        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(33, 105, 249));
        jTable1.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable1.setForeground(Color.BLUE);

        initTableData();
    }

    public ArrayList<TreatmentLocation> treatmentList() {
        ArrayList<TreatmentLocation> treatmentLocationList = new ArrayList();

        connectDB cn = new connectDB();
        Connection conn = null;
        try {
            conn = cn.getConnection();
            String sql = "SELECT * FROM TREATMENTLOCATION";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            TreatmentLocation treatmentLocation;
            while (rs.next()) {
                Location location = LocationService.getByID(rs.getString("AddressID"));
                treatmentLocation = new TreatmentLocation(rs.getString("TrmtLocaID"), rs.getString("TrmtLocaName"), location, rs.getInt("Capacity"), rs.getInt("Occupancy"));
                treatmentLocationList.add(treatmentLocation);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }

        return treatmentLocationList;
    }

    public void initTableData() {
        ArrayList<TreatmentLocation> treatmentLocationList = treatmentList();
        
        System.out.println(treatmentLocationList.get(1));
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[2];
        row[1] = treatmentLocationList.get(0).getName();
        row[1] = treatmentLocationList.get(0).getAddress();
        row[1] = treatmentLocationList.get(0).getCapacity();
        row[1] = treatmentLocationList.get(0).getOccupancy();
        
        model.addRow(row);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"a", "1", "2", "3", null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Address", "Capacity", "Occupancy", "Action"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
