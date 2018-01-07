package com.gzq;

import org.junit.Test;

/**
 * ${DESCRIPTION}
 *
 * @author guozhiqiang
 * @created 2018-01-04 18:40.
 */
public class IpCreator {

    @Test
    public void createIP() {
        for (int j = 94; j <= 107; j++) {
            if (j == 103) {
                j++;
            }
            System.out.println("192.168.13." + j + " ceb" + j);
        }
    }

    @Test
    public void createHostname() {
        for (int j = 94; j <= 107; j++) {
            if (j == 103) {
                j++;
            }
            System.out.println("echo NETWORKING=yes  > /etc/sysconfig/network" );
            System.out.println("echo HOSTNAME=ceb"+j+"  >> /etc/sysconfig/network");
            System.out.println("reboot");

            System.out.println();

        }
    }
}
