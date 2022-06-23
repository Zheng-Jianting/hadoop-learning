package com.zhengjianting.hadoop;

import org.apache.hadoop.conf.Configuration;

public class ConfigurationTest {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.addResource("configuration-1.xml");
        System.out.println(conf.get("color"));
    }
}