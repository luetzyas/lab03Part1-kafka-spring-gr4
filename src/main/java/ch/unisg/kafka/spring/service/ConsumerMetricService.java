package ch.unisg.kafka.spring.service;

import ch.unisg.kafka.spring.model.MetricSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class ConsumerMetricService {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @KafkaListener(topics = {"${spring.kafka.metric-application-topic}"}, containerFactory = "kafkaListenerStringFactory", groupId = "group_id")
    public void consumeMetricApplication(String metricApplication) {logger.info("---- -> Consumed Application metrics -> {}", metricApplication);
    }


    @KafkaListener(topics = {"${spring.kafka.metric-system-topic}"}, containerFactory = "kafkaListenerJsonFactory", groupId = "group_id")
    public void consumeMetricSystem(MetricSystem metricSystem) {logger.info("---- -> Consumed System metrics :: {}", metricSystem);
    }

}
