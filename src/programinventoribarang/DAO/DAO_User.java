/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.DAO;

import java.util.List;
import programinventoribarang.model.Model_User;

/**
 *
 * @author MohamadEsa
 */
public interface DAO_User {
    
    public List<Model_User>getALL();
    //menampilkan data yang ada dalam list
    public List<Model_User>getLogin(String user, String pass);
    //proses untuk login
    public void add(Model_User data);
    //proses untuk menambah data
    public void update(Model_User data);
    //proses untuk mengubah data
    public void delete(String kode);
    //proses untuk menghapus data
}
