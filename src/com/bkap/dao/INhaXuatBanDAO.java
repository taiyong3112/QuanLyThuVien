/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkap.dao;

import com.bkap.entities.NhaXuatBan;
import java.util.List;

/**
 *
 * @author TaiyoNg
 */
public interface INhaXuatBanDAO {
    List<NhaXuatBan> toList();
    NhaXuatBan find(String id);
    void add(NhaXuatBan nxb);
    void edit(NhaXuatBan nxb);
    void remove(String id);
}
