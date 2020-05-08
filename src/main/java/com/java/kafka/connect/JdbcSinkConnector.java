package com.java.kafka.connect;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;

import java.util.List;
import java.util.Map;

/**
 * @description: 自定义sink
 * @author: ws
 * @time: 2020/4/28 20:26
 */

public class JdbcSinkConnector extends SinkConnector{
    @Override
    public String version() {
        return null;
    }

    @Override
    public void start(Map<String, String> map) {

    }

    @Override
    public Class<? extends Task> taskClass() {
        return JdbcSinkTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int i) {
        return null;
    }

    @Override
    public void stop() {

    }

    @Override
    public ConfigDef config() {
        return null;
    }
}
