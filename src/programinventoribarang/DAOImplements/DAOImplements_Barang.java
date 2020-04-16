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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import programinventoribarang.DAO.DAO_Barang;
import programinventoribarang.config.dbUtilities;
import programinventoribarang.model.Model_Barang;

/**
 *
 * @author MohamadEsa
 */
public class DAOImplements_Barang implements DAO_Barang{

    Connection koneksi;
    
    public DAOImplements_Barang(){}
    
    @Override
    public List<Model_Barang> getALL() {
        koneksi = dbUtilities.config();
        
        List<Model_Barang> list = null;
        try {
            String SQL = "SELECT * FROM `barang` ORDER BY kode_barang";
            list = new ArrayList<Model_Barang>();
            
            Statement sta = koneksi.createStatement();
            ResultSet res = sta.executeQuery(SQL);
            
            while(res.next()){
                Model_Barang m = new Model_Barang();
                m.setKodeBarang(res.getString("kode_barang"));
                m.setNamaBarang(res.getString("nama_barang"));
                m.setSku(res.getString("sku_id"));
                m.setMerek(res.getString("merek"));
                m.setUkuran(res.getString("ukuran"));
                m.setSatuan(res.getString("satuan"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public List<Model_Barang> getkodeBarang(String kode) {
        koneksi = dbUtilities.config();
        
        List<Model_Barang> list = null;
        
        try {
            String SQL = "SELECT * FROM `barang` WHERE kode_barang= "+kode;
            list = new ArrayList<Model_Barang>();
            
            Statement sta = koneksi.createStatement();
            ResultSet res = sta.executeQuery(SQL);
            
            while(res.next()){
                Model_Barang m = new Model_Barang();
                m.setKodeBarang(res.getString("kode_barang"));
                m.setNamaBarang(res.getString("nama_barang"));
                m.setSku(res.getString("sku_id"));
                m.setMerek(res.getString("merek"));
                m.setUkuran(res.getString("ukuran"));
                m.setSatuan(res.getString("satuan"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    @Override
    public void add(Model_Barang data) {
        koneksi = dbUtilities.config();
        
        String kode = data.getKodeBarang();
        String nama = data.getNamaBarang();
        String sku = data.getSku();
        String merek = data.getMerek();
        String ukuran = data.getUkuran();
        String satuan = data.getSatuan();
        
        try {
            String SQL = "INSERT INTO `barang`(`kode_barang`, `nama_barang`, `sku_id`, `merek`, `ukuran`, `satuan`) VALUES (?,?,?,?,?,?)";
            PreparedStatement stat = koneksi.prepareStatement(SQL);
            
            stat.setString(1, kode);
            stat.setString(2, nama);
            stat.setString(3, sku);
            stat.setString(4, merek);
            stat.setString(5, ukuran);
            stat.setString(6, satuan);
            
            stat.executeUpdate();
            stat.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void update(Model_Barang data) {
        koneksi = dbUtilities.config();
        
        String kode = data.getKodeBarang();
        String nama = data.getNamaBarang();
        String sku = data.getSku();
        String merek = data.getMerek();
        String ukuran = data.getUkuran();
        String satuan = data.getSatuan();
        
        try {
            String SQL = "UPDATE `barang` SET `nama_barang`=?,`sku_id`=?,`merek`=?,`ukuran`=?,`satuan`=? WHERE `kode_barang`=?"; 
            
            PreparedStatement stat = koneksi.prepareStatement(SQL);
            
            stat.setString(1, nama);
            stat.setString(2, sku);
            stat.setString(3, merek);
            stat.setString(4, ukuran);
            stat.setString(5, satuan);
            stat.setString(6, kode);
            
            stat.executeUpdate();
            stat.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void delete(String kode) {
        koneksi = dbUtilities.config();
        System.out.println(kode);
        try {
            String SQL = "DELETE FROM barang WHERE kode_barang='"+kode+"'";
            PreparedStatement stat = koneksi.prepareStatement(SQL);
            stat.executeUpdate();
            stat.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
