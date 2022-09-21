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
public class ViPham {
    private int id;
    private String idDocGia;
    private String idSach;
    private String noiDungViPham;
    private float tienPhat;
    private String tenDocGia;
    private String tenSach;
    private Date ngayTao;
   
    public ViPham() {
    }

    public ViPham(int id, String idDocGia, String idSach, String noiDungViPham, float tienPhat, Date ngayTao) {
        this.id = id;
        this.idDocGia = idDocGia;
        this.idSach = idSach;
        this.noiDungViPham = noiDungViPham;
        this.tienPhat = tienPhat;
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

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public String getNoiDungViPham() {
        return noiDungViPham;
    }

    public void setNoiDungViPham(String noiDungViPham) {
        this.noiDungViPham = noiDungViPham;
    }

    public float getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(float tienPhat) {
        this.tienPhat = tienPhat;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    
    
    
    
    
}
