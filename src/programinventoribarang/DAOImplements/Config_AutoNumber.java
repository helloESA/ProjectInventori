/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.DAOImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import programinventoribarang.DAO.DAO_AutoNumber;
import programinventoribarang.model.NumberField;

/**
 *
 * @author MohamadEsa
 */
public class Config_AutoNumber implements DAO_AutoNumber{

    Connection koneksi;
    public Config_AutoNumber(){}
    
    @Override
    public String getAutoNumberInt(NumberField field) {
        String autoCode = "";
        int number = 0;
        String temporary = "";
        int pDepan = field.getAwalan().length();
        int pId = field.getPanjangField()-pDepan;
        String SQL = "SELECT RIGHT("+field.getNamaField()+", "+pId+") AS no_terakhir from "+field.getNamaTabel()+"ORDER BY no_terakhir";
        try {
            PreparedStatement sta = koneksi.prepareStatement(SQL);
            ResultSet res = sta.executeQuery();
            if(res.first()==false){
                number=1;
            } else{
                res.last();
                number=res.getInt("no_terakhir")+1;
            }
            String SNumber = String.valueOf(number);
            int panjangNumber=SNumber.length();
            
            for(int i=0;i<pId-panjangNumber;i++){
                temporary=temporary+"0";
            }
            
            autoCode = field.getAwalan()+temporary+number;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return autoCode;
    }
    
}
