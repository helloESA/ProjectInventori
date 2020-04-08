/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.controller;

import java.util.List;
import javax.swing.JOptionPane;
import programinventoribarang.DAO.DAO_User;
import programinventoribarang.DAOImplements.DAOImplements_User;
import programinventoribarang.model.Model_User;
import programinventoribarang.view.jD_Login;
import programinventoribarang.view.jF_MenuUtama;

/**
 *
 * @author MohamadEsa
 */
public class controller_login {
    jD_Login form;
    jF_MenuUtama newForm;
    DAO_User implement;
    List<Model_User> list;
    
    public controller_login(jD_Login form){
        this.form = form;
        newForm = new jF_MenuUtama();
        implement = new DAOImplements_User();
    }
    
    public void cek_login (jD_Login data){
            if(!data.getUser().getText().trim().isEmpty() && !data.getPassword().getText().trim().isEmpty()){
                String nama = data.getUser().getText();
                String pass = data.getPassword().getText();
                
                list = implement.getLogin(nama, pass);
                
                if(list.size()==1){
                    newForm.setVisible(true);
                    form.setVisible(false);
                } else{
                    JOptionPane.showMessageDialog(data, "Username atau Password Tidak Valid");
                }
            } else{
                JOptionPane.showMessageDialog(data, "Isi Username dan Password!");
            }
    }
}
