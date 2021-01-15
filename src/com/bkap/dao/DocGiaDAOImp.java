/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.DocGia;
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
public class DocGiaDAOImp implements IDocGiaDAO{

    @Override
    public List<DocGia> toList() {
        List<DocGia> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT * FROM DocGia", null);
        try {
            while(rs.next()){
                DocGia dg = new DocGia();
                dg.setId(rs.getString("id"));
                dg.setTenDocGia(rs.getString("tenDocGia"));
                dg.setEmail(rs.getString("email"));
                dg.setGioiTinh(rs.getBoolean("gioiTinh"));
                dg.setNgaySinh(rs.getString("ngaySinh"));
                dg.setSdt(rs.getString("sdt"));
                dg.setDiaChi(rs.getString("diaChi"));
                dg.setNgayTao(rs.getDate("ngayTao"));
                data.add(dg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public DocGia find(String id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM DocGia WHERE id LIKE ?", id);
        try {
            while(rs.next()){
                DocGia dg = new DocGia();
                dg.setId(rs.getString("id"));
                dg.setTenDocGia(rs.getString("tenDocGia"));
                dg.setEmail(rs.getString("email"));
                dg.setGioiTinh(rs.getBoolean("gioiTinh"));
                dg.setNgaySinh(rs.getString("ngaySinh"));
                dg.setSdt(rs.getString("sdt"));
                dg.setDiaChi(rs.getString("diaChi"));
                dg.setNgayTao(rs.getDate("ngayTao"));
                return dg;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(DocGia dg) {
        SqlConnection.executeUpdate("INSERT INTO DocGia VALUES(?,?,?,?,?,?,?,?)", dg.getId(), dg.getTenDocGia(), dg.getEmail(), dg.getGioiTinh(), dg.getNgaySinh(), dg.getSdt(), dg.getDiaChi(), dg.getNgayTao());
    }

    @Override
    public void edit(DocGia dg) {
        SqlConnection.executeUpdate("UPDATE DocGia SET tenDocGia = ?, email = ?, gioiTinh = ?, ngaySinh = ?, sdt = ?, diaChi = ? WHERE id = ?", dg.getTenDocGia(), dg.getEmail(), dg.getGioiTinh(), dg.getNgaySinh(), dg.getSdt(), dg.getDiaChi(), dg.getId());
    }

    @Override
    public void remove(String id) {
        SqlConnection.executeUpdate("DELETE FROM DocGia WHERE id = ?", id);
    }
    
}
