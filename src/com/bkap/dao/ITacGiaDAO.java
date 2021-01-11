/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.TacGia;
import java.util.List;

/**
 *
 * @author TaiyoNg
 */
public interface ITacGiaDAO {
    List<TacGia> toList();
    TacGia find(String id);
    void add(TacGia tg);
    void edit(TacGia tg);
    void remove(String id);
}
