package com.deevscale.principalapi.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    private final String bootstrapAddress;
    private final String newAccountTopicName;

    public KafkaTopicConfig(
            @Value(value = "${principal.kafka.bootstrapServers}")
            String bootstrapAddress,

            @Value(value = "${principal.kafka.topicNames.account.addNew}")
            String newAccountTopicName) {
        this.bootstrapAddress = bootstrapAddress;
        this.newAccountTopicName = newAccountTopicName;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic(newAccountTopicName, 1, (short) 1);
    }
}
