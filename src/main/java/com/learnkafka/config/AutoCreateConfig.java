package com.learnkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * not recommended for production
 * why?
 * 1. Static Configuration:
 * Hardcoding topic configurations directly into the code makes it difficult to manage and scale. In a production
 * environment, you often need the flexibility to adjust topic configurations dynamically without modifying the code.
 * For example, you might need to change the number of partitions or replicas based on changing requirements or load
 * patterns.
 *
 * 2. Limited Flexibility:
 * By configuring topics directly in the code, you lose the ability to dynamically configure topics based on external
 * factors or conditions. In a dynamic environment, you may need to adjust topic configurations based on factors like
 * resource availability, workload distribution, or data retention policies.
 *
 * 3. Centralized Configuration Management:
 * It's best practice to manage configuration settings, including Kafka topic configurations, centrally using
 * configuration management tools or platforms. This allows for easier management, versioning, and consistency across
 * different environments. Hardcoding configurations in code makes it harder to manage and track changes.
 *
 * 4. Scalability and Maintainability:
 * Hardcoded configurations can become a maintenance burden as the application scales and evolves. Separating
 * configuration from code promotes modularity and makes it easier to scale and maintain the application over time.
 */
@Configuration
public class AutoCreateConfig {
    @Value("${spring.kafka.topic}")
    private String topic;

    @Bean
    public NewTopic libraryEvents() {
        return TopicBuilder
                .name(topic)
                .partitions(3)
                .replicas(3)
                .build();
    }
}
