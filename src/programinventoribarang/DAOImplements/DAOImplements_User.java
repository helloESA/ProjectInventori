/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.DAOImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import programinventoribarang.config.dbUtilities;
import programinventoribarang.model.Model_User;
import programinventoribarang.DAO.DAO_User;

/**
 *
 * @author MohamadEsa
 */
public class DAOImplements_User implements DAO_User{
    
    Connection koneksi ;
    
    public DAOImplements_User(){}

    @Override
    public List<Model_User> getALL() {
        koneksi = dbUtilities.config();
        
        List<Model_User> list = null;
        
        try {
            String query = "SELECT * FROM user ORDER BY id ASC";
            
            list = new ArrayList<Model_User>();
            
            Statement sta = koneksi.createStatement();
            ResultSet rst = sta.executeQuery(query);
            
            while(rst.next()){
                Model_User m = new Model_User();
                m.setId(rst.getString("id"));
                m.setKode_user(rst.getString("kode_user"));
                m.setNama_user(rst.getString("nama_user"));
                m.setPassword(rst.getString("password"));
                m.setNama_lengkap(rst.getString("nama_lengkap"));
                m.setLevel(rst.getString("level"));
                m.setNo_telepon(rst.getString("no_telepon"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
                
    }

    @Override
    public List<Model_User> getLogin(String user, String pass) {
        koneksi = dbUtilities.config();
        
        List<Model_User> list = null;
        
        try {
            String query = "SELECT * FROM user WHERE nama_user='"+user+"' AND password = MD5('"+pass+"')";
            
            list = new ArrayList<Model_User>();
            
            Statement sta = koneksi.createStatement();
            ResultSet rst = sta.executeQuery(query);
            
            while(rst.next()){
                Model_User m = new Model_User();
                m.setId(rst.getString("id"));
                m.setKode_user(rst.getString("kode_user"));
                m.setNama_user(rst.getString("nama_user"));
                m.setPassword(rst.getString("password"));
                m.setNama_lengkap(rst.getString("nama_lengkap"));
                m.setLevel(rst.getString("level"));
                m.setNo_telepon(rst.getString("no_telepon"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Model_User data) {
        koneksi = dbUtilities.config();
        
        String kode = data.getKode_user();
        String uname = data.getNama_user();
        String pass = data.getPassword();
        String nama = data.getNama_lengkap();
        String level = data.getLevel();
        String no_telepon = data.getNo_telepon();
        
        try {
            String query = "INSERT INTO user (kode_user, nama_user, password, nama_lengkap, level, no_telepon) VALUES (?, ?, MD5(?), ?, ?, ?);";
            PreparedStatement sta = koneksi.prepareStatement(query);
                sta.setString(1, kode);
                sta.setString(2, uname);
                sta.setString(3, pass);
                sta.setString(4, nama);
                sta.setString(5, level);
                sta.setString(6, no_telepon);
                sta.executeUpdate(); 
            sta.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Model_User data) {
        koneksi = dbUtilities.config();
        
        String id = data.getId();
        String kode = data.getKode_user();
        String uname = data.getNama_user();
        String pass = data.getPassword();
        String nama = data.getNama_lengkap();
        String level = data.getLevel();
        String no_telepon = data.getNo_telepon();
        
        try {
            String query = "UPDATE user SET kode_user=?,nama_user=?,password=?,nama_lengkap=?,level=?,no_telepon=? WHERE `id`=?";
            
            PreparedStatement sta = koneksi.prepareStatement(query);
                sta.setString(1, kode);
                sta.setString(2, uname);
                sta.setString(3, pass);
                sta.setString(4, nama);
                sta.setString(5, level);
                sta.setString(6, no_telepon);
                sta.setString(0, id);
                sta.executeUpdate(); 
            sta.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String kode) {
        koneksi = dbUtilities.config();
        
        try {
            String query = "DELETE FROM user WHERE id="+kode;
            PreparedStatement sta = koneksi.prepareStatement(query);
            
            sta.executeUpdate();
            
            sta.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
}
