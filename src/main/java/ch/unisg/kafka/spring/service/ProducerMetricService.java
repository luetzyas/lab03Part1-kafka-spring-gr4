package ch.unisg.kafka.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerMetricService<T> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("metric-application-topic")
    private String metricApplicationTopic;

    @Value("${spring.kafka.metric-system-topic}")
    private String metricSystemTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateMetricApplication;

    @Autowired
    private KafkaTemplate<String, T> kafkaTemplateMetricSystem;


    public void sendMetricApplication(String metricApplication) {
        logger.info("++++ -> Publishing application -> {}", metricApplication);
        kafkaTemplateMetricApplication.send(metricApplicationTopic, metricApplication);
    }


    public void sendMetricSystem(T metricSystem) {
        logger.info("++++ -> Publishing system :: {}", metricSystem);
        kafkaTemplateMetricSystem.send(metricSystemTopic, metricSystem);
    }
}
