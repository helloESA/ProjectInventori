/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.DAO;

import java.util.List;
import programinventoribarang.model.Model_Barang;

/**
 *
 * @author MohamadEsa
 */
public interface DAO_Barang {
    public List<Model_Barang>getALL();
    //menampilkan data yang ada dalam list
    public List<Model_Barang>getkodeBarang(String kode);
    //proses untuk login
    public void add(Model_Barang data);
    //proses untuk menambah data
    public void update(Model_Barang data);
    //proses untuk mengubah data
    public void delete(String kode);
    //proses untuk menghapus data
}
