package com.kina.form.user;

import Networking.TCPClient;
import com.kina.form.manager.*;
import com.kina.form.admin.*;
import com.kina.main.User_Main;
import com.kina.model.Location;
import com.kina.model.Pack;
import com.kina.model.PackDetail;
import com.kina.model.Product;
import com.kina.model.Receipt;
import com.kina.model.TreatmentLocation;
import com.kina.service.PackService;
import com.kina.service.ProductService;
import com.kina.service.ReceiptService;
import com.kina.service.TreatmentLocationService;
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
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class User_Receipt_Detail extends javax.swing.JFrame {

    String id;

    public User_Receipt_Detail() {
        init();
        initComponents();
    }

    public User_Receipt_Detail(String id, Boolean status) {
        init();
        initComponents();
        initTable(status);
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
    
    public void initTable(Boolean status){
        if (status == Boolean.TRUE) {
            btnPaid.setEnabled(false);
        }
        
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(33, 105, 249));
        jTable1.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable1.setForeground(Color.BLUE);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setCellSelectionEnabled(false);
        jScrollPane3.setBorder(new EmptyBorder(1, 1, 1, 1));
        
    }

    public void initData(String id) {
        List<Pack> packList = new ArrayList<Pack>();
        packList = ReceiptService.getAllPack(id);
        int total = 0;
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < packList.size(); i++) {
            row[0] = packList.get(i).getId();
            row[1] = packList.get(i).getName();
            row[2] = packList.get(i).getLimitQuantity();
            row[3] = packList.get(i).getPrice();
            int money = packList.get(i).getLimitQuantity() * packList.get(i).getPrice();
            row[4] = money;
            total += money;
            model.addRow(row);
        }
        txtTotal.setText("Total = " + total);
        this.id = id;
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnPaid = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtTotal = new javax.swing.JLabel();

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
        jLabel1.setText("RECEIPT DETAIL");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnClose.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnPaid.setBackground(new java.awt.Color(0, 255, 51));
        btnPaid.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPaid.setForeground(new java.awt.Color(255, 255, 255));
        btnPaid.setText("PAY");
        btnPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaidActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pack ID", "Pack Name", "Quantity", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        txtTotal.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotal.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTotal)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(btnPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addComponent(txtTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        handleClosing();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaidActionPerformed
       //Init data
       Receipt receipt = new Receipt();
       receipt.setId(this.id);
       receipt.setUserID(User_Main.userID);
       receipt.setStatus(Boolean.TRUE);
       String money = txtTotal.getText().substring(8);
       receipt.setTotalAmount(Integer.parseInt(money));
       //update paymentrecord
        int countPayment = ReceiptService.countPayment() + 1;
        String idPayment = "PM" + String.format("%04d", countPayment);
        
        if (ReceiptService.addPayment(idPayment, receipt)) {
            //update receipt status
            ReceiptService.updateReceipt(receipt);
            
        } 
        String amount = "0";
        if(money != null)
            amount = money;
        TCPClient tcpClient;      
        tcpClient = new TCPClient(User_Main.userID, amount);
        tcpClient.connectServer();
        tcpClient.start();
       //update receipt status
//               JOptionPane.showConfirmDialog(null, "Your payment is success!", "Successful", JOptionPane.OK_OPTION);
               dispose();

    }//GEN-LAST:event_btnPaidActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String id = model.getValueAt(index, 0).toString();
        String name = model.getValueAt(index, 1).toString();
        String quanti = model.getValueAt(index, 2).toString();
        String price = model.getValueAt(index, 3).toString();

        User_Shopping_Detail.main(id, name, quanti, price);
    }//GEN-LAST:event_jTable1MouseClicked

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

    public static void main(String id, Boolean status) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Receipt_Detail(id, status).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPaid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtTotal;
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
