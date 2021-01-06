/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.TheLoai;
import java.util.List;

/**
 *
 * @author TaiyoNg
 */
public interface ITheLoaiDAO {
    List<TheLoai> toList();
    TheLoai find(String id);
    void add(TheLoai tl);
    void edit(TheLoai tl);
    void remove(String id);
}
