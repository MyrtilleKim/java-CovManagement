package com.kina.form.manager;

import com.kina.form.admin.*;
import com.kina.model.Location;
import com.kina.model.Pack;
import com.kina.model.PackDetail;
import com.kina.model.TreatmentLocation;
import com.kina.model.User;
import com.kina.service.LocationService;
import com.kina.service.PackService;
import com.kina.service.TreatmentLocationService;
import com.kina.service.UserService;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EventObject;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class Manager_User_Detail extends javax.swing.JFrame {

    String id;

    public Manager_User_Detail() {
        init();
        initComponents();
    }

    public Manager_User_Detail(String id) {
        init();
        initComponents();
        initComboBox();
        initData(id);
    }

    public void init() {
        JPanel panel = new javax.swing.JPanel() {
            protected void paintComponent(Graphics grphcs) {
                Graphics2D g2 = (Graphics2D) grphcs;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gra = new GradientPaint(0, 0, new Color(33, 105, 249), getWidth(), 0, new Color(93, 58, 196));
                g2.setPaint(gra);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        setContentPane(panel);
    }

    public void initComboBox() {
        //Init birth year
        List<String> years = new ArrayList<String>();
        years.add("--Year--");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1960; i <= year; i++) {
            years.add(Integer.toString(i));
        }
        txtYear.setModel(new DefaultComboBoxModel<String>(years.toArray(new String[0])));
        
        //Init city
        List<String> city = new ArrayList<String>();
        city = LocationService.getAllCity();
        city.add(0, "--City--");
        txtCity.setModel(new DefaultComboBoxModel<String>(city.toArray(new String[0])));

        //Init ward
        List<String> ward = new ArrayList<String>();
        ward = LocationService.getAllWard();
        ward.add(0, "--Ward--");
        txtWard.setModel(new DefaultComboBoxModel<String>(ward.toArray(new String[0])));

        //Init district
        List<String> district = new ArrayList<String>();
        district = LocationService.getAllDistrict();
        district.add(0, "--District--");
        txtDistrict.setModel(new DefaultComboBoxModel<String>(district.toArray(new String[0])));
        
        //Init treatment location
        List<TreatmentLocation> treatment = TreatmentLocationService.getAll();
        List<String>  treatmentName = new ArrayList<String>();
        for(int i = 0; i < treatment.size(); i++) {
            treatmentName.add((treatment.get(i).getName()));
        }
 
        treatmentName.add(0, "--Treament Location--");
        txtTreatment.setModel(new DefaultComboBoxModel<String>(treatmentName.toArray(new String[0])));
        
        treatmentList.removeAll();
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("There is no treatment record.");
        treatmentList.setModel(listModel);

    }
    
    public void initData(String id) {
        
        
        //Init data
        User user = UserService.getUserById(id);
        System.out.println(user.toString());
        txtID.setText(user.getNoID());
        txtName.setText(user.getName());
        
//        txtProduct.setText(name);
//        txtUnit.setText(unit);
//        boxOccupancy.setValue(price);

//        txtID.setText(pack.getId());
//        txtPack.setText(pack.getName());
//        txtQuantity.setValue(pack.getLimitQuantity());
//        txtDeadline.setDate(pack.getDateExp());
//        txtPrice.setText(Integer.toString(pack.getPrice()));

//        List<PackDetail> packList = pack.getProList();
//        DefaultTableModel model = (DefaultTableModel) tblProd.getModel();
//        
//        tblProd.getColumn("Delete").setCellRenderer(new ButtonCellRenderer());
//        tblProd.getColumn("Delete").setCellEditor(new ButtonCellEditor());
//        
//        Object[] row = new Object[5];
//
//        for (int i = 0; i < packList.size(); i++) {
//            row[0] = packList.get(i).getProduct().getName();
//            row[1] = packList.get(i).getQuantity();
//            Icon icon = new ImageIcon("U:\\Java\\TP\\management-covid\\src\\com\\kina\\icon\\delete.png");
//            row[2] = icon;
//            model.addRow(row);
//        }

        this.id = id;
//        this.name = name;
//        this.unit = unit;
//        this.price = price;
//        this.image = image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        relatedList = new javax.swing.JTable();
        lblCapacity3 = new javax.swing.JLabel();
        btnSave1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtYear = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        txtCity = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtDistrict = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtWard = new javax.swing.JComboBox<>();
        txtID3 = new javax.swing.JTextField();
        txtTreatment = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCapacity4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        treatmentList = new javax.swing.JList<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDIT USER DETAIL");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt.setForeground(new java.awt.Color(255, 255, 255));
        txt.setText("Birth Year");

        btnSave.setBackground(new java.awt.Color(255, 0, 0));
        btnSave.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("DELETE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address:");

        relatedList.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        relatedList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(relatedList);
        if (relatedList.getColumnModel().getColumnCount() > 0) {
            relatedList.getColumnModel().getColumn(1).setMinWidth(80);
            relatedList.getColumnModel().getColumn(1).setPreferredWidth(80);
            relatedList.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        lblCapacity3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCapacity3.setForeground(new java.awt.Color(255, 255, 255));
        lblCapacity3.setText("Related List");

        btnSave1.setBackground(new java.awt.Color(0, 255, 51));
        btnSave1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnSave1.setForeground(new java.awt.Color(255, 255, 255));
        btnSave1.setText("SAVE");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("City:");

        txtID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setText("jTextField1");
        txtID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtID.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Full Name:");

        txtYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setText("txtName");
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtName.setOpaque(false);

        txtCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("District");

        txtDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDistrictActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ward");

        txtWard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtID3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtID3.setForeground(new java.awt.Color(255, 255, 255));
        txtID3.setText("txtAddress");
        txtID3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtID3.setOpaque(false);

        txtTreatment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Treatment Location");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No ID:");

        lblCapacity4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCapacity4.setForeground(new java.awt.Color(255, 255, 255));
        lblCapacity4.setText("Treament Record");

        treatmentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(treatmentList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCapacity3)
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtWard, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addComponent(lblCapacity4)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID3))
                            .addComponent(txtTreatment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtName)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtID))))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWard))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCapacity3)
                    .addComponent(lblCapacity4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        handleClosing();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //if has unsave data: save
//        if (hasUnsaveData()) {
//            int ca = (int) boxCapacity.getValue();
//            int oc = (int) boxOccupancy.getValue();
//            String na = txtTreamentName.getText();
//        
//            String addressId = "DC0005";
//            Location location = new Location(addressId, "a", "a", "a", "a");
//            TreatmentLocation treatmentLocation = new TreatmentLocation(id, na, location, oc, ca);
//            TreatmentLocationService.updOne(treatmentLocation);
//        }
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void txtDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDistrictActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDistrictActionPerformed

    private void handleClosing() {
        if (hasUnsaveData()) {
            int answer = showWarningMessage();

            switch (answer) {
                case JOptionPane.YES_OPTION:
                    System.out.println("Save and Quit");
                    break;

                case JOptionPane.NO_OPTION:
                    System.out.println("Don't Save and Quit");
                    dispose();
                    break;

                case JOptionPane.CANCEL_OPTION:
                    System.out.println("Don't Quit");
                    dispose();
                    break;
            }
        } else {
            dispose();
        }
    }

    private int showWarningMessage() {
        String[] buttonLabels = new String[]{"Yes", "Cancel"};
        String defaultOption = buttonLabels[0];
        Icon icon = null;

        return JOptionPane.showOptionDialog(this,
                "There's still something unsaved.\n"
                + "Do you want to save before exiting?",
                "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                icon,
                buttonLabels,
                defaultOption);
    }

    private boolean hasUnsaveData() {
////        int ca = (int) boxCapacity.getValue();
////        int oc = (int) boxOccupancy.getValue();
////        String na = txtTreamentName.getText();
//
//        if (ca != this.capacity || oc != this.occupancy || !na.equals(this.name)) {
//                    System.out.println(ca);
//
//            return true;
//        }         
        return false;
    }

    public static void main(String id) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager_User_Detail(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCapacity3;
    private javax.swing.JLabel lblCapacity4;
    private javax.swing.JTable relatedList;
    private javax.swing.JList<String> treatmentList;
    private javax.swing.JLabel txt;
    private javax.swing.JComboBox<String> txtCity;
    private javax.swing.JComboBox<String> txtDistrict;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID3;
    private javax.swing.JTextField txtName;
    private javax.swing.JComboBox<String> txtTreatment;
    private javax.swing.JComboBox<String> txtWard;
    private javax.swing.JComboBox<String> txtYear;
    // End of variables declaration//GEN-END:variables

    public static class ButtonCellRenderer extends JButton implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            if (value != null) {
//                setText("Delete");
//            } else {
//                setText("Delete Me");
//            }
//            if (isSelected) {
//                setForeground(table.getSelectionForeground());
//                setBackground(table.getSelectionBackground());
//            } else {
//                setForeground(table.getForeground());
//                setBackground(UIManager.getColor("Button.background"));
//            }
            setText("Delete");
            setForeground(Color.white);
            setBackground(Color.red);

            return this;
        }
    }
    
    public static class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor {

        private JButton editor;
        private Object value;
        private int row;
        private JTable table;

        public ButtonCellEditor() {
            editor = new JButton();
            editor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (table != null) {
                        fireEditingStopped();
                        TableModel model = table.getModel();
                        if (model instanceof DefaultTableModel) {
                            ((DefaultTableModel) model).removeRow(row);
                        }
                    }
                }
            });
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return true;
        }

        @Override
        public Object getCellEditorValue() {
            return value;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.table = table;
            this.row = row;
            this.value = value;
//            editor.setBackground(Color.red);
//            if (value != null) {
//                editor.setText("Delete row " + value.toString());
//            } else {
//                editor.setText("Delete Me");
//            }
            if (isSelected) {
                editor.setForeground(table.getSelectionForeground());
                editor.setBackground(table.getSelectionBackground());
            } else {
                editor.setForeground(table.getForeground());
                editor.setBackground(UIManager.getColor("Button.background"));
            }
            
            return editor;
        }
    }
}
