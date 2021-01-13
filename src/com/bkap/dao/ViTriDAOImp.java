/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;


import com.bkap.entities.ViTri;
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
public class ViTriDAOImp implements IViTriDAO{

    @Override
    public List<ViTri> toList() {
        List<ViTri> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT * FROM ViTri", null);
        try {
            while(rs.next()){
                ViTri vt = new ViTri();
                vt.setId(rs.getString("id"));
                vt.setTenViTri(rs.getString("tenViTri"));
                vt.setNgayTao(rs.getDate("ngayTao"));
                data.add(vt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public ViTri find(String id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM ViTri WHERE id = ?", id);
        try {
            while(rs.next()){
                ViTri vt = new ViTri();
                vt.setId(rs.getString("id"));
                vt.setTenViTri(rs.getString("tenViTri"));
                vt.setNgayTao(rs.getDate("ngayTao"));
                return vt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(ViTri vt) {
        SqlConnection.executeUpdate("INSERT INTO ViTri VALUES(?,?,?)", vt.getId(), vt.getTenViTri(), vt.getNgayTao());
    }

    @Override
    public void edit(ViTri vt) {
       SqlConnection.executeUpdate("UPDATE ViTri SET tenViTri = ? WHERE id = ?", vt.getTenViTri(), vt.getId());
    }

    @Override
    public void remove(String id) {
        SqlConnection.executeUpdate("DELETE FROM ViTri WHERE id = ?", id);
    }
    
}
