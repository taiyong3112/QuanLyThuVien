/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.NguoiDung;
import java.util.List;

/**
 *
 * @author TaiyoNg
 */
public interface INguoiDungDAO {
    List<NguoiDung> toList();
    NguoiDung find(String id);
    void add(NguoiDung nd);
    void edit(NguoiDung nd);
    void remove(String id);
}
