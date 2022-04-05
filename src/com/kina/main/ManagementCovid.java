package com.kina.main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.kina.login.LoginForm;
import com.kina.sql.connectDB;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ManagementCovid {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
//        connectDB a = new connectDB();
//        a.getConnection();
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());

        } catch (Exception e) {
            e.printStackTrace();
        }
//        LoginForm.main();
        Admin_Main.main();

//        User_Main.main();
    }

}
