/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.NguoiDung;
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
public class NguoiDungDAOImp implements INguoiDungDAO{

    @Override
    public List<NguoiDung> toList() {
        List<NguoiDung> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT * FROM NguoiDung", null);
        try {
            while(rs.next()){
                NguoiDung nd = new NguoiDung();
                nd.setId(rs.getString("id"));
                nd.setTenNguoiDung(rs.getString("tenNguoiDung"));
                nd.setEmail(rs.getString("email"));
                nd.setMatKhau(rs.getString("matKhau"));
                nd.setSdt(rs.getString("sdt"));
                nd.setRole(rs.getString("role"));
                nd.setNgayTao(rs.getDate("ngayTao"));
                data.add(nd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public NguoiDung find(String id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM NguoiDung WHERE id = ?", id);
        try {
            while(rs.next()){
                NguoiDung nd = new NguoiDung();
                nd.setId(rs.getString("id"));
                nd.setTenNguoiDung(rs.getString("tenNguoiDung"));
                nd.setEmail(rs.getString("email"));
                nd.setMatKhau(rs.getString("matKhau"));
                nd.setSdt(rs.getString("sdt"));
                nd.setRole(rs.getString("role"));
                nd.setNgayTao(rs.getDate("ngayTao"));
                return nd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(NguoiDung nd) {
        SqlConnection.executeUpdate("INSERT INTO NguoiDung VALUES(?,?,?,?,?,?,?)", nd.getId(), nd.getTenNguoiDung(), nd.getEmail(), nd.getMatKhau(), nd.getSdt(), nd.getRole(), nd.getNgayTao());
    }

    @Override
    public void edit(NguoiDung nd) {
        SqlConnection.executeUpdate("UPDATE NguoiDung SET tenNguoiDung = ?, email = ?, sdt = ?, role = ? WHERE id = ?", nd.getTenNguoiDung(), nd.getEmail(), nd.getSdt(), nd.getRole(), nd.getId());
    }

    @Override
    public void remove(String id) {
        SqlConnection.executeUpdate("DELETE FROM NguoiDung WHERE id = ?", id);
    }
    public NguoiDung findByEmail(String email) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM NguoiDung WHERE email LIKE ?", email);
        try {
            while(rs.next()){
                NguoiDung nd = new NguoiDung();
                nd.setId(rs.getString("id"));
                nd.setTenNguoiDung(rs.getString("tenNguoiDung"));
                nd.setEmail(rs.getString("email"));
                nd.setMatKhau(rs.getString("matKhau"));
                nd.setSdt(rs.getString("sdt"));
                nd.setRole(rs.getString("role"));
                nd.setNgayTao(rs.getDate("ngayTao"));
                return nd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
