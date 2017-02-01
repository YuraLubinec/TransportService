/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.enums;

/**
 *
 * @author us9522
 */
public enum StatusOrderEnum {
        NEW("нове"),
        DONE("підтверджене"),
        CANCELED("відмінено"),
        PAID("оплачено"),
        CANCELEDAFTERPAID("відмінено після оплати"),
        COMPLETED("виконане");

        String statusOrder;
        
        private StatusOrderEnum(String statusOrder){
            this.statusOrder = statusOrder;
        }
        
        public String getStatusOrder(){
            return statusOrder;
        }
}
