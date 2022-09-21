/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.PhieuMuon;
import com.bkap.util.SqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
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


public class PhieuMuonDAOImp implements IPhieuMuonDAO{
    Connection conn = SqlConnection.getConnect();
    @Override
    public List<PhieuMuon> toList() {
        List<PhieuMuon> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("{call PhieuMuon_List()}", null);
        try {
            while(rs.next()){
                PhieuMuon pm = new PhieuMuon();
                pm.setId(rs.getInt("id"));
                pm.setIdDocGia(rs.getString("idDocGia"));
                pm.setSoLuongMuon(rs.getInt("soLuongMuon"));
                pm.setNgayMuon(rs.getDate("ngayMuon"));
                pm.setHanTra(rs.getDate("hanTra"));
                pm.setTongTien(rs.getFloat("tongTien"));
                pm.setTrangThai(rs.getBoolean("trangThai"));
                pm.setNgayTao(rs.getDate("ngayTao"));
                pm.setTenDocGia(rs.getString("tenDocGia"));
                data.add(pm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public PhieuMuon find(int id) {
        ResultSet rs = SqlConnection.execute("{call PhieuMuon_Find(?)}", id);
        try {
            while(rs.next()){
                PhieuMuon pm = new PhieuMuon();
                pm.setId(rs.getInt("id"));
                pm.setIdDocGia(rs.getString("idDocGia"));
                pm.setSoLuongMuon(rs.getInt("soLuongMuon"));
                pm.setNgayMuon(rs.getDate("ngayMuon"));
                pm.setHanTra(rs.getDate("hanTra"));
                pm.setTongTien(rs.getFloat("tongTien"));
                pm.setTrangThai(rs.getBoolean("trangThai"));
                pm.setNgayTao(rs.getDate("ngayTao"));
                pm.setTenDocGia(rs.getString("tenDocGia"));
                pm.setNgaySinh(rs.getString("ngaySinh"));
                pm.setEmail(rs.getString("email"));
                pm.setSdt(rs.getString("sdt"));
                return pm;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(PhieuMuon pm) {
        SqlConnection.executeUpdate("{call PhieuMuon_Insert(?,?,?,?,?,?,?)}", pm.getIdDocGia(), pm.getSoLuongMuon(), pm.getNgayMuon(), pm.getHanTra(), pm.getTongTien(), pm.isTrangThai(), pm.getNgayTao());

    }
    
    @Override
    public void remove(int id) {
        SqlConnection.executeUpdate("{call PhieuMuon_Delete(?)}", id);
    }

    @Override
    public PhieuMuon findLastInserted() {
        ResultSet rs = SqlConnection.execute("{call PhieuMuon_FindLastInsert()}", null);
        try {
            while(rs.next()){
                PhieuMuon pm = new PhieuMuon();
                pm.setId(rs.getInt("id"));
                pm.setIdDocGia(rs.getString("idDocGia"));
                pm.setSoLuongMuon(rs.getInt("soLuongMuon"));
                pm.setNgayMuon(rs.getDate("ngayMuon"));
                pm.setHanTra(rs.getDate("hanTra"));
                pm.setTongTien(rs.getFloat("tongTien"));
                pm.setTrangThai(rs.getBoolean("trangThai"));
                pm.setNgayTao(rs.getDate("ngayTao"));
                return pm;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void edit(PhieuMuon pm) {
        SqlConnection.executeUpdate("{call PhieuMuon_Edit(?,?)}",pm.isTrangThai(), pm.getId());
    }
    
}
