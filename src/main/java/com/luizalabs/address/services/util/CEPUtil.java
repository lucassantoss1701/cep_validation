package com.luizalabs.address.services.util;

public class CEPUtil {

    public static String returnCEP(String cep, int index){
        StringBuilder stringBuilder = new StringBuilder(cep);
        stringBuilder.setCharAt(index, '0');
        return stringBuilder.toString();
    }
}
