/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.Sach;
import java.util.List;

/**
 *
 * @author TaiyoNg
 */
public interface ISachDAO {
    List<Sach> toList();
    Sach find(String id);
    void add(Sach bk);
    void edit(Sach bk);
    void remove(String id);
}
