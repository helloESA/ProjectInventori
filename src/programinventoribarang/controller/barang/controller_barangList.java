/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.controller.barang;

import java.util.List;
import programinventoribarang.DAO.DAO_Barang;
import programinventoribarang.DAOImplements.DAOImplements_Barang;
import programinventoribarang.model.Model_Barang;
import programinventoribarang.tablemodel.table_barang;
import programinventoribarang.view.barang.jF_KelolaBarang;

/**
 *
 * @author MohamadEsa
 */
public class controller_barangList {
    jF_KelolaBarang barang;
    DAO_Barang impl;
    List<Model_Barang> list;
    
    public controller_barangList(jF_KelolaBarang barang){
        this.barang = barang;
        impl = new DAOImplements_Barang();
    }
    
    public void isiTable(){
        list = impl.getALL();
        table_barang table = new table_barang(list);
        barang.getTableDataBarang().setModel(table);
    }
    
    public void delete(String kode){
        impl.delete(kode);
    }
}
