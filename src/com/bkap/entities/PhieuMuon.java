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
public class PhieuMuon {
    private int id;
    private String idDocGia;
    private int soLuongMuon;
    private Date ngayMuon;
    private Date hanTra;
    private float tongTien;
    private boolean trangThai;
    private Date ngayTao;

    public PhieuMuon() {
    }

    public PhieuMuon(int id, String idDocGia, int soLuongMuon, Date ngayMuon, Date hanTra, float tongTien, boolean trangThai, Date ngayTao) {
        this.id = id;
        this.idDocGia = idDocGia;
        this.soLuongMuon = soLuongMuon;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdDocGia() {
        return idDocGia;
    }

    public void setIdDocGia(String idDocGia) {
        this.idDocGia = idDocGia;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
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
