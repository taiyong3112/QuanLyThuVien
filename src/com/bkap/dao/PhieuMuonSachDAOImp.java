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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TaiyoNg
 */
public class PhieuMuonSachDAOImp implements IPhieuMuonSachDAO{

    @Override
    public List<PhieuMuonSach> find(int id) {
        List<PhieuMuonSach> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("{call PhieuMuonSach_FindList(?)}", id);
        try {
            while (rs.next()){
                PhieuMuonSach pms = new PhieuMuonSach();
                pms.setIdPhieuMuon(rs.getInt("idPhieuMuon"));
                pms.setIdSach(rs.getString("idSach"));
                pms.setNgayTra(rs.getDate("ngayTra"));
                data.add(pms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonSachDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public void add(PhieuMuonSach pms) {
        SqlConnection.executeUpdate("{call PhieuMuonSach_Insert(?,?,?)}", pms.getIdPhieuMuon(), pms.getIdSach(), pms.getNgayTra());
    }

    @Override
    public void edit(PhieuMuonSach pms) {
        SqlConnection.executeUpdate("UPDATE PhieuMuon_Sach SET ngayTra = ? WHERE idPhieuMuon = ? AND idSach = ?", pms.getNgayTra(), pms.getIdPhieuMuon(), pms.getIdSach());
    }

    @Override
    public void remove(int id) {
        SqlConnection.executeUpdate("DELETE FROM PhieuMuon_Sach WHERE idPhieuMuon = ?", id);
    }
    
    public List<PhieuMuonSach> findBook(int id) {
        List<PhieuMuonSach> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT pms.*, sa.tenSach, tg.butDanh , nxb.tenNXB "
                + "FROM PhieuMuon_Sach pms "
                + "JOIN Sach sa ON pms.idSach = sa.id "
                + "JOIN TacGia tg ON sa.idTacGia = tg.id "
                + "JOIN NhaXuatBan nxb ON sa.idNXB = nxb.id "
                + "WHERE pms.idPhieuMuon = ?", id);
        try {
            while (rs.next()){
                PhieuMuonSach pms = new PhieuMuonSach();
                pms.setIdPhieuMuon(rs.getInt("idPhieuMuon"));
                pms.setIdSach(rs.getString("idSach"));
                pms.setNgayTra(rs.getDate("ngayTra"));
                pms.setButDanh(rs.getString("butDanh"));
                pms.setTenSach(rs.getString("tenSach"));
                pms.setTenNXB(rs.getString("tenNXB"));
                data.add(pms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonSachDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public PhieuMuonSach findSingle(int idPhieuMuon, String idSach) {
        List<PhieuMuonSach> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT * FROM PhieuMuon_Sach WHERE idPhieuMuon = ? AND idSach LIKE ?", idPhieuMuon, idSach);
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
}
