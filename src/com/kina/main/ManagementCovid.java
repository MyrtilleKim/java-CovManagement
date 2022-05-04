package com.kina.main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.kina.login.ChangePwd;
import com.kina.login.CreateAdmin;
import com.kina.login.LoginForm;
import com.kina.service.AccountService;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ManagementCovid {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            int init = AccountService.countAccount();
            

//            if (init == 0) {
//                CreateAdmin.main();
//            } else {
//                LoginForm.main();
//            }
                           
//            Admin_Main.main();
//            Manager_Main.main();
//            User_Main.main("BN0001");           
          
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
