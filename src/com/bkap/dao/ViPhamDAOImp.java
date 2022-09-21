/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.ViPham;
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
public class ViPhamDAOImp implements IViPhamDAO {

    @Override
    public List<ViPham> toList() {
        List<ViPham> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT vp.*, dg.tenDocGia FROM ViPham vp JOIN DocGia dg ON vp.idDocGia = dg.id", null);
        try {
            while (rs.next()) {
                ViPham vp = new ViPham();
                vp.setId(rs.getInt("id"));
                vp.setIdDocGia(rs.getString("idDocGia"));
                vp.setIdSach(rs.getString("idSach"));
                vp.setNoiDungViPham(rs.getString("noiDungViPham"));
                vp.setTienPhat(rs.getFloat("tienPhat"));
                vp.setNgayTao(rs.getDate("ngayTao"));
                vp.setTenDocGia(rs.getString("tenDocGia"));
                data.add(vp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViPhamDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public ViPham find(int id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM ViPham WHERE id = ?", id);
        try {
            while (rs.next()) {
                ViPham vp = new ViPham();
                vp.setId(rs.getInt("id"));
                vp.setIdDocGia(rs.getString("idDocGia"));
                vp.setIdSach(rs.getString("idSach"));
                vp.setNoiDungViPham(rs.getString("noiDungViPham"));
                vp.setTienPhat(rs.getFloat("tienPhat"));
                vp.setNgayTao(rs.getDate("ngayTao"));
                return vp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViPhamDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(ViPham vp) {
        SqlConnection.executeUpdate("INSERT INTO ViPham VALUES(?,?,?,?,?)", vp.getIdDocGia(), vp.getIdSach(), vp.getNoiDungViPham(), vp.getTienPhat(), vp.getNgayTao());
    }

    @Override
    public void remove(int id) {
        SqlConnection.executeUpdate("DELETE FROM ViPham WHERE id = ?",id);
    }

}
