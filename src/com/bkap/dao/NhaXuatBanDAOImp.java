/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.NhaXuatBan;
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
public class NhaXuatBanDAOImp implements INhaXuatBanDAO{

    @Override
    public List<NhaXuatBan> toList() {
        List<NhaXuatBan> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT * FROM NhaXuatBan", null);
        try {
            while(rs.next()){
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setId(rs.getString("id"));
                nxb.setTenNXB(rs.getString("tenNXB"));
                nxb.setNgayTao(rs.getDate("ngayTao"));
                data.add(nxb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public NhaXuatBan find(String id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM NhaXuatBan WHERE id = ?", id);
        try {
            while(rs.next()){
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setId(rs.getString("id"));
                nxb.setTenNXB(rs.getString("tenTheLoai"));
                nxb.setNgayTao(rs.getDate("ngayTao"));
                return nxb;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(NhaXuatBan nxb) {
        SqlConnection.executeUpdate("INSERT INTO NhaXuatBan VALUES(?,?,?)", nxb.getId(), nxb.getTenNXB(), nxb.getNgayTao());
    }

    @Override
    public void edit(NhaXuatBan nxb) {
        SqlConnection.executeUpdate("UPDATE NhaXuatBan SET tenNXB = ? WHERE id = ?", nxb.getTenNXB(),nxb.getId());
    }

    @Override
    public void remove(String id) {
         SqlConnection.executeUpdate("DELETE FROM NhaXuatBan WHERE id =?", id);
    }
    
}
