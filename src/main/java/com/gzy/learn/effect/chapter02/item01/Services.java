/**
 * Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
 */
package com.gzy.learn.effect.chapter02.item01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: Services <br/>
 *
 * @author wangao110@hotmail.com
 * @version 1.0
 * @date 2016年9月28日
 * @since JDK 1.7
 */
public class Services {
    private Services() {
    }

    private static final String DEFAULT_PROVIDER_NAME = "<def>";
    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();

    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return p.newService();
    }
}
