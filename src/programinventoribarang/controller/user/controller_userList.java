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
import programinventoribarang.tablemodel.table_user;
import programinventoribarang.view.user.JF_KelolaUser;

/**
 *
 * @author MohamadEsa
 */
public class controller_userList {
    JF_KelolaUser user;
    DAO_User impl;
    List<Model_User> list;
    
    public controller_userList(JF_KelolaUser user){
        this.user=user;
        impl = new DAOImplements_User();
    }
    
    public void isiTable(){
        list = impl.getALL();
        table_user table = new table_user(list);
        user.getTableDataUser().setModel(table);
    }
    
    public void delete(String kode){
        impl.delete(kode);
    }
}
