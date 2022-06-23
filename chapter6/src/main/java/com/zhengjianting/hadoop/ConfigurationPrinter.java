package com.zhengjianting.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.Map;

public class ConfigurationPrinter extends Configured implements Tool {
    static {
        Configuration.addDefaultResource("pseudo-distributed/core-site.xml");
        Configuration.addDefaultResource("pseudo-distributed/hdfs-site.xml");
        Configuration.addDefaultResource("pseudo-distributed/yarn-site.xml");
        Configuration.addDefaultResource("pseudo-distributed/mapred-site.xml");
    }

    @Override
    public int run(String[] strings) throws Exception {
        Configuration conf = getConf();
        for (Map.Entry<String, String> entry : conf) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new ConfigurationPrinter(), args);
        System.exit(exitCode);
    }
}