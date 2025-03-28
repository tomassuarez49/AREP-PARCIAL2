package com.mycompany.parcial2;

import java.util.Arrays;

public class lucasSeq {

    public String listar(int value){

        if(value == 0){
            return "2";
        }
        String x = "2";
        for(int i=1;i <= value;i++){ 
            int res = calc(i);
            String result = Integer.toString(res);
            x = x + "," + result;
            
        }
        return x;
    }


    public int calc(int value){
        if (value == 0){
            return 2;
        }
        else if(value == 1){
            return 1;
        }
        else{
            return (calc(value -1) + calc(value-2));
        }
    }
}
