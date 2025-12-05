/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ResetPasswordDao;
import model.ResetUser;

/**
 *
 * @author salaj
 */
public class ResetPasswordController {
    public boolean resetPassword(String email, String newPass) {

        ResetUser user = new ResetUser();
        user.setEmail(email);
        user.setNewPassword(newPass);

        ResetPasswordDao dao = new ResetPasswordDao();

        return dao.updatePassword(user);
    }
}
