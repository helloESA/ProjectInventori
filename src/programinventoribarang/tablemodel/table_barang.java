/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import programinventoribarang.model.Model_Barang;

/**
 *
 * @author MohamadEsa
 */
public class table_barang extends AbstractTableModel{

    List<Model_Barang> list;
    
    public table_barang(List<Model_Barang> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public String getColumnName(int col) {
        switch(col){
            case 0 : return "KODE BARANG";
            case 1 : return "NAMA BARANG";
            case 2 : return "SKU ID";
            case 3 : return "MEREK";
            case 4 : return "UKURAN";
            case 5 : return "SATUAN";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0 : return list.get(row).getKodeBarang();
            case 1 : return list.get(row).getNamaBarang();
            case 2 : return list.get(row).getSku();
            case 3 : return list.get(row).getMerek();
            case 4 : return list.get(row).getUkuran();
            case 5 : return list.get(row).getSatuan();
            default: return null;
        }
    }
    
}
