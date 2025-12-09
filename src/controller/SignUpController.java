/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SignUpDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;
import view.SignUp;
import view.LoginView;

/**
 *
 * @author DELL
 */
public class SignUpController {
    private final SignUpDao userdao = new SignUpDao();
    private final SignUp userView;
    
    public SignUpController(SignUp userView) {
        this.userView =  userView;

        userView.AddConfirmListener(new ConfirmActionListener());

        userView.AddSignInListener(new SignInActionListener());

        userView.AddCancelListener(e -> close());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class ConfirmActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ex) {
            try {
                String mobileNumber = userView.getMobileNumber().getText();
                String email = userView.getEmail().getText();
                String fullName = userView.getFullName().getText();
                String password = userView.getPassword().getText();

                UserData userdata = new UserData(mobileNumber, email, fullName, password);

                boolean exists = userdao.checkUser(userdata);
                if (exists) {
                    JOptionPane.showMessageDialog(userView,
                            "User already exists with this email or mobile number.");
                } else {
                    userdao.signUp(userdata);
                    JOptionPane.showMessageDialog(userView,
                            "Registration successful! Please log in.");

                    LoginView loginView = new LoginView();
                    LoginController loginController = new LoginController(loginView);

                    close();             
                    loginController.open();
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(userView, "Error: " + e.getMessage());
            }
        }
    }

    class SignInActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginView loginView = new LoginView();
            LoginController loginController = new LoginController(loginView);

            close();
            loginController.open();
        }
    }
}