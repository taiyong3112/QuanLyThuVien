/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.Sach;
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
public class SachDAOImp implements ISachDAO{

    @Override
    public List<Sach> toList() {
        List<Sach> data = new ArrayList<>();
        ResultSet rs = SqlConnection.execute("SELECT sa.*, tl.tenTheLoai as 'tenTheLoai', tg.butDanh as 'butDanh', nxb.tenNXB as 'tenNXB', vt.tenViTri as 'tenViTri'"
                + "FROM Sach sa "
                + "JOIN TheLoai tl ON sa.idTheLoai = tl.id "
                + "JOIN TacGia tg ON sa.idTacGia = tg.id "
                + "JOIN NhaXuatBan nxb ON sa.idNXB = nxb.id "
                + "JOIN ViTri vt ON sa.idViTri = vt.id", null);
        try {
            while(rs.next()){
                Sach sa = new Sach();
                sa.setId(rs.getString("id"));
                sa.setIdTheLoai(rs.getString("idTheLoai"));
                sa.setIdTacGia(rs.getString("idTacGia"));
                sa.setIdNXB(rs.getString("idNXB"));
                sa.setIdViTri(rs.getString("idViTri"));
                sa.setTenSach(rs.getString("tenSach"));
                sa.setNamXuatBan(rs.getInt("namXuatBan"));
                sa.setSoTrang(rs.getInt("soTrang"));
                sa.setGiaMuon(rs.getFloat("giaMuon"));
                sa.setSoLuong(rs.getInt("soLuong"));
                sa.setTrangThai(rs.getBoolean("trangThai"));
                sa.setNgayTao(rs.getDate("ngayTao"));
                sa.setTenTheLoai(rs.getString("tenTheLoai"));
                sa.setButDanh(rs.getString("butDanh"));
                sa.setTenNXB(rs.getString("tenNXB"));
                sa.setTenViTri(rs.getString("tenViTri"));
                data.add(sa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public Sach find(String id) {
        ResultSet rs = SqlConnection.execute("SELECT * FROM Sach WHERE id = ?", id);
        try {
            while(rs.next()){
                Sach sa = new Sach();
                sa.setId(rs.getString("id"));
                sa.setIdTheLoai(rs.getString("idTheLoai"));
                sa.setIdTacGia(rs.getString("idTacGia"));
                sa.setIdNXB(rs.getString("idNXB"));
                sa.setIdViTri(rs.getString("idViTri"));
                sa.setTenSach(rs.getString("tenSach"));
                sa.setNamXuatBan(rs.getInt("namXuatBan"));
                sa.setSoTrang(rs.getInt("soTrang"));
                sa.setGiaMuon(rs.getFloat("giaMuon"));
                sa.setSoLuong(rs.getInt("soLuong"));
                sa.setTrangThai(rs.getBoolean("trangThai"));
                sa.setNgayTao(rs.getDate("ngayTao"));
                return sa;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(Sach bk) {
        SqlConnection.executeUpdate("INSERT INTO Sach VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", 
                bk.getId(), bk.getIdTheLoai(), bk.getIdTacGia(), bk.getIdNXB(), bk.getIdViTri(), bk.getTenSach(), bk.getNamXuatBan(), bk.getSoTrang(), bk.getGiaMuon(), bk.getSoLuong(), bk.isTrangThai(), bk.getNgayTao());
    }

    @Override
    public void edit(Sach bk) {
        SqlConnection.executeUpdate("UPDATE Sach Set idTheLoai = ?, idTacGia = ?, idNXB = ?, idViTri = ?, tenSach = ?, namXuatBan = ?, soTrang = ?, giaMuon = ?, soLuong = ?, trangThai = ? WHERE id = ?", 
                bk.getIdTheLoai(), bk.getIdTacGia(), bk.getIdNXB(), bk.getIdViTri(), bk.getTenSach(), bk.getNamXuatBan(), bk.getSoTrang(), bk.getGiaMuon(), bk.getSoLuong(), bk.isTrangThai(), bk.getId());
    }

    @Override
    public void remove(String id) {
        SqlConnection.executeUpdate("DELETE FROM Sach WHERE id = ?", id);
    }
    
}
