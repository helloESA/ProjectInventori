/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.controller.user;

import java.util.List;
import programinventoribarang.DAO.DAO_User;
import programinventoribarang.DAOImplements.DAOImplements_User;
import programinventoribarang.model.Model_User;
import programinventoribarang.view.user.jF_EditUser;

/**
 *
 * @author MohamadEsa
 */
public class controller_userEdit {
    jF_EditUser userFrame;
    DAO_User impl;
    List<Model_User> list;
    
    public controller_userEdit(jF_EditUser user){
        this.userFrame = user;
        impl = new DAOImplements_User();
    }
    
    public void edit(jF_EditUser data){
        Model_User u = new Model_User();
        u.setKode_user(data.getTxtKodeUser().getText());
        u.setNama_user(data.getTxtNamaUser().getText());
        u.setPassword(data.getTxtPassword().getText().trim());
        u.setNama_lengkap(data.getTxtNamaLengkap().getText());
        u.setLevel(data.getCbLevel().getSelectedItem().toString());
        u.setNo_telepon(data.getTxtTelepon().getText());
        impl.update(u);
    }
    
    
}
