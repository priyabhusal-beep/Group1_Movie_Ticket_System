/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SgnUpDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;
import view.SignUp;

/**
 *
 * @author DELL
 */
public class SignUpController {
    private final SgnUpDao userdao = new SgnUpDao() ;
    private final SignUp userView;
    
    public SignUpController(SignUp userView) {
        this.userView =  userView;
        userView.AddSignUpListener(new AddActionListener());             
    }
    public void open() {
        this.userView.setVisible(true);
    }
    public void close() {
        this.userView.dispose();
        
    }
        class AddActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ex) {
            
            try{
                
                String mobileNumber = userView.getMobileNumber().getText();
                String email = userView.getEmail().getText();
                String fullName = userView.getFullName().getText();
                String password =userView.getPassword().getText();
                UserData userdata = new UserData (mobileNumber, email,fullName, password);
                boolean check = userdao.checkUser(userdata);
                if (check) {
                    JOptionPane.showConfirmDialog(userView, "Duplicated user");
                } else {
                    userdao.signUp(userdata);
                    JOptionPane.showMessageDialog(userView, "Successfull");
//                    Login lc = new Login();
//                    LoginController log = new LoginController(lc);
//                    log.close();
//                    log.open();
                }
           
            }catch(Exception e){
                System.out.println(e);
            }
     }
     
        }

    
}
