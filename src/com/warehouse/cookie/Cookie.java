/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.cookie;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pawel_000
 */
public class Cookie {
    private static Map memory = new HashMap();
    
    public static void add(final String where, final String value){
        if(memory.get(where) != null && memory.get(where).equals(value))
            memory.replace(where, value);
        else
            memory.put(where, value);
    }
    
    public static String get(final String value){
        return (String) memory.get(value);
    }
    
    public static void remove(final String value){
        memory.remove(value);
    }
    
    public static void clear(){
        memory.clear();
    }
}
