package com.who.springboot.serives;

public interface KvSerive {
    void putKv(String key, String value);

    String getValue(String key);
}
