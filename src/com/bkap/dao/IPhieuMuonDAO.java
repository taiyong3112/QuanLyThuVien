/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.PhieuMuon;
import java.util.List;

/**
 *
 * @author TaiyoNg
 */
public interface IPhieuMuonDAO {
    List<PhieuMuon> toList();
    PhieuMuon find(int id);
    void add(PhieuMuon pm);
    void remove(int id);
}
