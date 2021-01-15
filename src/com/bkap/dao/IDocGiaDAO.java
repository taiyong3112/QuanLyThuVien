/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.DocGia;
import java.util.List;

/**
 *
 * @author TaiyoNg
 */
public interface IDocGiaDAO {
    List<DocGia> toList();
    DocGia find(String id);
    void add(DocGia dg);
    void edit(DocGia dg);
    void remove(String id);
}
