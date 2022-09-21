/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.entities;

import java.sql.Date;

/**
 *
 * @author TaiyoNg
 */
public class NguoiDung {
    private String id;
    private String tenNguoiDung;
    private String email;
    private String matKhau;
    private String sdt;
    private String role;
    private Date ngayTao;
    
    public NguoiDung() {
    }


    public NguoiDung(String id, String tenNguoiDung, String email, String matKhau, String sdt, String role, Date ngayTao) {
        this.id = id;
        this.tenNguoiDung = tenNguoiDung;
        this.email = email;
        this.matKhau = matKhau;
        this.sdt = sdt;
        this.role = role;
        this.ngayTao = ngayTao;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
}
