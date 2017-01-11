/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.informations;

/**
 *
 * @author pawel_000
 */
public class PickingInformations extends AbstractInformation{
    private String workerLogin;
    private String itemCode;

    public String getWorkerLogin() {
        return workerLogin;
    }

    public void setWorkerLogin(String workerLogin) {
        this.workerLogin = workerLogin;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
