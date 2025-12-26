/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;
import view.LoginView;
import dao.LoginDao;
import view.SignUp;
import view.Reset_Password;
import view.TheaterView;

/**
 *
 * @author HP
 */
public class LoginController {
    private final LoginDao logindao = new LoginDao();
    private final LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;

        loginView.AddLoginListner(new LoginListner());
        loginView.AddRegisterListner(new RegisterListener());
        loginView.AddForgotPasswordListener(new ForgotPasswordListener());
    }

    public void open() {
        this.loginView.setVisible(true);
    }

    public void close() {
        this.loginView.dispose();
    }

    class LoginListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String emailOrMobile = loginView.getEmail().getText();
                String password = loginView.getPassword().getText();
                UserData userdata = new UserData(emailOrMobile, password);
                boolean check = logindao.login(userdata);

                if (check) {
                    JOptionPane.showMessageDialog(loginView, "Login successful");
                    TheaterView view = new TheaterView();
                    TheaterController controller = new TheaterController(view);
                    controller.open();
                } else {
                    JOptionPane.showMessageDialog(loginView, "Invalid credentials");
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SignUp signUpView = new SignUp();
            SignUpController signUpController = new SignUpController(signUpView);

            close();
            signUpController.open();
        }
    }

    class ForgotPasswordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = loginView.getEmail().getText().trim();

            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(loginView, "Please enter your email first.");
                return;
            }

            Reset_Password resetView = new Reset_Password(email);
            resetView.setVisible(true);
        }
    }
}
