/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.ViPham;
import java.util.List;

/**
 *
 * @author TaiyoNg
 */
public interface IViPhamDAO {
    List<ViPham> toList();
    ViPham find(int id);
    void add(ViPham vp);
    void remove(int id);
}
