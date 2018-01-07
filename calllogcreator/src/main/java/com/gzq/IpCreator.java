package com.gzq;

/**
 * ${DESCRIPTION}
 *
 * @author guozhiqiang
 * @created 2018-01-04 18:26.
 */

public class IpCreator {

    public static void main(String[] args) {
        int start = 94;
        int end =107;
        for (int j = start; j <= end; j++) {
            if(j==103){
                j++;
            }
            System.out.println("192.168.13."+j+" ceb"+j);
        }

    }



}
