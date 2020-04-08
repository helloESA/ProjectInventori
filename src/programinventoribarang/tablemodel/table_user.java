/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import programinventoribarang.model.Model_User;

/**
 *
 * @author MohamadEsa
 */
public class table_user extends AbstractTableModel{

    List<Model_User> list;
    
    public table_user(List<Model_User> list){
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
    public String getColumnName(int col){
        switch(col){
            case 0 : return "ID";
            case 1 : return "KODE USER";
            case 2 : return "NAMA USER";
            case 3 : return "NAMA LENGKAP";
            case 4 : return "LEVEL";
            case 5 : return "NO TELEPON";
            default : return null;
        }
    }
    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0 : return list.get(row).getId();
            case 1 : return list.get(row).getKode_user();
            case 2 : return list.get(row).getNama_user();
            case 3 : return list.get(row).getNama_lengkap();
            case 4 : return list.get(row).getLevel();
            case 5 : return list.get(row).getNo_telepon();
            default : return null;
        }
    }
    
}
