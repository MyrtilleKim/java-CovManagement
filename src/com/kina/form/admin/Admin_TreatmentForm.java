package com.kina.form.admin;

import com.kina.model.Location;
import com.kina.model.TreatmentLocation;
import com.kina.service.LocationService;
import com.kina.sql.connectDB;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class Admin_TreatmentForm extends javax.swing.JPanel {

    public Admin_TreatmentForm() {
        initComponents();
        setOpaque(false);
        initTable();
        initTableData();
    }

    public void initTable() {
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(33, 105, 249));
        jTable1.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable1.setForeground(Color.BLUE);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setCellSelectionEnabled(false);
        jTable1.getColumn("").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
        jScrollPane1.setBorder(new EmptyBorder(1, 1, 1, 1));
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

//        System.out.println(treatmentLocationList.size());
//        System.out.println(treatmentLocationList.get(1));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[4];

        for (int i = 0; i < treatmentLocationList.size(); i++) {
            row[0] = treatmentLocationList.get(i).getName();
            row[1] = treatmentLocationList.get(i).getCapacity();
            row[2] = treatmentLocationList.get(i).getOccupancy();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Capacity", "Occupancy", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setOpaque(false);
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
        }

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Treament Location Management");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String name = model.getValueAt(index, 0).toString();
        System.out.println(name);
        
        Admin_TreatmentLocation_Detail.main();
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "Detail" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.setText("Detail");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "Detail" : value.toString();
        button.setText("");
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
            // 
            // 
//            JOptionPane.showMessageDialog(button, label + ": Ouch!");
//            // System.out.println(label + ": Ouch!");
            Admin_TreatmentLocation_Detail.main();
              
        }
        isPushed = false;
        return new String(label);
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
