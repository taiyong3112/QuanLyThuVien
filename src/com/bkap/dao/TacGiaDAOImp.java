/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.TacGia;
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
public class TacGiaDAOImp implements ITacGiaDAO{

    @Override
    public List<TacGia> toList() {
        List<TacGia> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT * FROM TacGia", null);
        try {
            while(rs.next()){
                TacGia tg = new TacGia();
                tg.setId(rs.getString("id"));
                tg.setButDanh(rs.getString("butDanh"));
                tg.setTenThat(rs.getString("tenThat"));
                tg.setNamSinh(rs.getInt("namSinh"));
                tg.setGioiTinh(rs.getBoolean("gioiTinh"));
                tg.setNgayTao(rs.getDate("ngayTao"));
                data.add(tg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public TacGia find(String id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM TacGia WHERE id = ?", id);
        try {
            while(rs.next()){
                TacGia tg = new TacGia();
                tg.setId(rs.getString("id"));
                tg.setButDanh(rs.getString("butDanh"));
                tg.setTenThat(rs.getString("tenThat"));
                tg.setNamSinh(rs.getInt("namSinh"));
                tg.setGioiTinh(rs.getBoolean("gioiTinh"));
                tg.setNgayTao(rs.getDate("ngayTao"));
                return tg;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(TacGia tg) {
        SqlConnection.executeUpdate("INSERT INTO TacGia VALUES (?,?,?,?,?,?)", tg.getId(), tg.getButDanh(), tg.getTenThat(), tg.isGioiTinh(), tg.getNamSinh(), tg.getNgayTao());
    }

    @Override
    public void edit(TacGia tg) {
        SqlConnection.executeUpdate("UPDATE TacGia SET butDanh = ?, tenThat = ?, gioiTinh = ?, namSinh = ? WHERE id = ?", tg.getButDanh(), tg.getTenThat(), tg.isGioiTinh(), tg.getNamSinh(), tg.getId());
    }

    @Override
    public void remove(String id) {
        SqlConnection.executeUpdate("DELETE FROM TacGia WHERE id = ?", id);
    }
    
}
