/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.ViTri;
import java.util.List;

/**
 *
 * @author NAM_STD
 */
public interface IViTriDAO {
    List<ViTri> toList();
    ViTri find (String id);
    void add(ViTri vt);
    void edit(ViTri vt);
    void remove(String id);
}
