/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

import com.warehouse.entity.PalletsPicked;
import java.util.List;

/**
 *
 * @author pawel_000
 */
public interface PickingDao {
    public List<PalletsPicked> getPickedPallets();
}
