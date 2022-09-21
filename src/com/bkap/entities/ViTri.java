/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.entities;

import java.sql.Date;

/**
 *
 * @author NAM_STD
 */
public class ViTri {
    private String id;
    private String tenViTri;
    private Date ngayTao;

    public ViTri() {
    }

    public ViTri(String id, String tenViTri, Date ngayTao) {
        this.id = id;
        this.tenViTri = tenViTri;
        this.ngayTao = ngayTao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return this.tenViTri;
    }
    
    
}


