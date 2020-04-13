/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.controller.barang;

import java.util.List;
import programinventoribarang.DAO.DAO_AutoNumber;
import programinventoribarang.DAO.DAO_Barang;
import programinventoribarang.DAOImplements.DAOImplements_Barang;
import programinventoribarang.model.Model_Barang;
import programinventoribarang.view.barang.jF_InputBarang;

/**
 *
 * @author MohamadEsa
 */
public class controller_barangAdd {
    jF_InputBarang frame;
    DAO_Barang impl;
    List<Model_Barang> list;
    
    public controller_barangAdd(jF_InputBarang frame){
        this.frame = frame;
        impl = new DAOImplements_Barang();
    }
    
    public void insert(jF_InputBarang data){
        Model_Barang b = new Model_Barang();
        b.setKodeBarang(data.getTxtKode().getText());
        b.setNamaBarang(data.getTxtNama().getText());
        b.setSku(data.getTxtSku().getText());
        b.setMerek(data.getTxtMerek().getText());
        b.setUkuran(data.getTxtUkuran().getText());
        b.setSatuan(data.getCbSatuan().getSelectedItem().toString());
        impl.add(b);
    }
}
