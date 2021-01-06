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
public class TheLoai {
    private String id;
    private String tenTheLoai;
    private boolean trangThai;
    private Date ngayTao;

    public TheLoai() {
    }

    public TheLoai(String id, String tenTheLoai, boolean trangThai, Date ngayTao) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
    
}
