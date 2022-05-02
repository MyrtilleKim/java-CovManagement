package com.kina.main;

import com.kina.component.Header;
import com.kina.component.menu.Manager_Menu;
import com.kina.event.EventMenuSelected;
import com.kina.form.MainForm;
import com.kina.form.admin.Admin_TreatmentForm;
import com.kina.form.admin.Admin_ManagerForm;
import com.kina.form.manager.Manager_Dashboard;
import com.kina.form.manager.Manager_PackForm;
import com.kina.form.manager.Manager_ProductForm;
import com.kina.form.manager.Manager_UserForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Manager_Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Manager_Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;

    public Manager_Main() {
        initComponents();
        init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);

        menu = new Manager_Menu();
        header = new Header();
        main = new MainForm();

        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
   
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 50 + (170 * (1f - fraction));
                } else {
                    width = 50 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }
        };

        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);

        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
            }
        });
        
        header.changeWelcome("Welcome, Manager");

        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex) {
                System.out.println("Menu Index : " + menuIndex);
                switch (menuIndex) {
                    case 0:
                        main.showForm(new Manager_Dashboard());
                        break;
                    case 1:
                        main.showForm(new Manager_UserForm());
                        break;

                    case 2:
                        main.showForm(new Manager_ProductForm());
                        break;

                    case 3:
                        main.showForm(new Manager_PackForm());
                        break;
                }
            }
        }
        );
        menu.initMenuItem();

        main.showForm(new Manager_Dashboard());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main() {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
