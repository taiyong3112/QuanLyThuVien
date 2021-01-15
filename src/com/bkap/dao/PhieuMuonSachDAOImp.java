/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.PhieuMuonSach;
import com.bkap.util.SqlConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TaiyoNg
 */
public class PhieuMuonSachDAOImp implements IPhieuMuonSachDAO{

    @Override
    public PhieuMuonSach find(int id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM PhieuMuon_Sach WHERE idPhieuMuon LIKE ?", id);
        try {
            while (rs.next()){
                PhieuMuonSach pms = new PhieuMuonSach();
                pms.setIdPhieuMuon(rs.getInt("idPhieuMuon"));
                pms.setIdSach(rs.getString("idSach"));
                pms.setNgayTra(rs.getDate("ngayTra"));
                return pms;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonSachDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(PhieuMuonSach pms) {
        SqlConnection.executeUpdate("INSERT INTO PhieuMuon_Sach VALUES(?,?,?)", pms.getIdPhieuMuon(), pms.getIdSach(), pms.getNgayTra());
    }

    @Override
    public void edit(PhieuMuonSach pms) {
        SqlConnection.executeUpdate("UPDATE PhieuMuon_Sach SET ngayTra = ? WHERE idPhieuMuon = ? AND idSach = ?", pms.getNgayTra(), pms.getIdPhieuMuon(), pms.getIdSach());
    }

    @Override
    public void remove(int id) {
        SqlConnection.executeUpdate("DELETE FROM PhieuMuon_Sach WHERE idPhieuMuon = ?", id);
    }
    
}
