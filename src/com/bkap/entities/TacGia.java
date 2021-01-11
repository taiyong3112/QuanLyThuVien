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
public class TacGia {
    private String id;
    private String butDanh;
    private String tenThat;
    private String gioiTinh;
    private int namSinh;
    private Date ngayTao;

    public TacGia() {
    }

    public TacGia(String id, String butDanh, String tenThat, String gioiTinh, int namSinh, Date ngayTao) {
        this.id = id;
        this.butDanh = butDanh;
        this.tenThat = tenThat;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.ngayTao = ngayTao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getButDanh() {
        return butDanh;
    }

    public void setButDanh(String butDanh) {
        this.butDanh = butDanh;
    }

    public String getTenThat() {
        return tenThat;
    }

    public void setTenThat(String tenThat) {
        this.tenThat = tenThat;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    
    
    
}
