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
public class PhieuMuonSach {
    private int idPhieuMuon;
    private String idSach;
    private Date ngayTra;

    public PhieuMuonSach() {
    }

    public PhieuMuonSach(int idPhieuMuon, String idSach, Date ngayTra) {
        this.idPhieuMuon = idPhieuMuon;
        this.idSach = idSach;
        this.ngayTra = ngayTra;
    }

    public int getIdPhieuMuon() {
        return idPhieuMuon;
    }

    public void setIdPhieuMuon(int idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
    
    
}
