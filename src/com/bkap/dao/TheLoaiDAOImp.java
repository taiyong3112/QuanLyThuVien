/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.TheLoai;
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
public class TheLoaiDAOImp implements ITheLoaiDAO{

    @Override
    public List<TheLoai> toList() {
        List<TheLoai> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT * FROM TheLoai", null);
        try {
            while(rs.next()){
                TheLoai tl = new TheLoai();
                tl.setId(rs.getString("id"));
                tl.setTenTheLoai(rs.getString("tenTheLoai"));
                tl.setTrangThai(rs.getBoolean("trangThai"));
                tl.setNgayTao(rs.getDate("ngayTao"));
                data.add(tl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public TheLoai find(String id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM TheLoai WHERE id = ?", id);
        try {
            while(rs.next()){
                TheLoai tl = new TheLoai();
                tl.setId(rs.getString("id"));
                tl.setTenTheLoai(rs.getString("tenTheLoai"));
                tl.setTrangThai(rs.getBoolean("trangThai"));
                tl.setNgayTao(rs.getDate("ngayTao"));
                return tl;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(TheLoai tl) {
        SqlConnection.executeUpdate("INSERT INTO TheLoai(?,?,?)", tl.getId(), tl.getTenTheLoai(), tl.isTrangThai());
    }

    @Override
    public void edit(TheLoai tl) {
        SqlConnection.executeUpdate("UPDATE TheLoai SET tenTheLoai = ?, trangThai = ? WHERE id = ?",  tl.getTenTheLoai(), tl.isTrangThai(), tl.getId());
    }

    @Override
    public void remove(String id) {
        SqlConnection.executeUpdate("DELETE FROM TheLoai WHERE id = ?", id);
    }
    
}
