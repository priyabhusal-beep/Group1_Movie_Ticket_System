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
    public boolean reset(String usernameOrEmail, String newPassword) {
        ResetUser user = new ResetUser();
        user.setEmail(usernameOrEmail);
        user.setNewPassword(newPassword);

        ResetPasswordDao dao = new ResetPasswordDao();
        return dao.updatePassword(user);
    }
}
