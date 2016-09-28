/**
 * Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
 */
package com.gzy.learn.effect.chapter02.item01;

import java.math.BigInteger;

/**
 * ClassName: Test <br/>
 *
 * @author wangao110@hotmail.com
 * @version 1.0
 * @date 2016年9月28日
 * @since JDK 1.7
 */
public class Test {
    public static void main(String[] args) {
        Boolean b = Boolean.valueOf("s");
        System.out.println(b);
        BigInteger bi = BigInteger.valueOf(1L);
        System.out.println(bi);
        // Providers would execute these lines
        Services.registerDefaultProvider(DEFAULT_PROVIDER);
        Services.registerProvider("comp", COMP_PROVIDER);
        Services.registerProvider("armed", ARMED_PROVIDER);

        // Clients would execute these lines
        Service s1 = Services.newInstance();
        Service s2 = Services.newInstance("comp");
        Service s3 = Services.newInstance("armed");
        System.out.printf("%s, %s, %s%n", s1, s2, s3);
    }

    private static Provider DEFAULT_PROVIDER = new Provider() {
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Default service";
                }
            };
        }
    };

    private static Provider COMP_PROVIDER = new Provider() {
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Complementary service";
                }
            };
        }
    };

    private static Provider ARMED_PROVIDER = new Provider() {
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Armed service";
                }
            };
        }
    };
}
