/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.PhieuMuonSach;

/**
 *
 * @author TaiyoNg
 */
public interface IPhieuMuonSachDAO {
    PhieuMuonSach find(int id);
    void add(PhieuMuonSach pms);
    void edit(PhieuMuonSach pms);
    void remove(int id);
}
