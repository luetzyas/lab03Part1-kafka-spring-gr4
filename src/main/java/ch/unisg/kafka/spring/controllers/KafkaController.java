package ch.unisg.kafka.spring.controllers;

import ch.unisg.kafka.spring.model.MetricSystem;
import ch.unisg.kafka.spring.model.SuperHero;
import ch.unisg.kafka.spring.service.ProducerMetricService;
import ch.unisg.kafka.spring.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    @Autowired
    private ProducerService<SuperHero> producerService;

    @Autowired
    private ProducerMetricService<MetricSystem> producerMetricService;

    @GetMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return "Successfully published message..!";
    }

    @PostMapping(value = "/publish")
    public Map<String, Object> sendObjectToKafkaTopic(@RequestBody SuperHero superHero) {
        producerService.sendSuperHeroMessage(superHero);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Successfully published Super Hero..!");
        map.put("payload", superHero);

        return map;
    }

    @GetMapping(value = "/publish/metrics")
    public String sendMetricApplicationToKafkaTopic(@RequestParam("application") String application) {
        producerMetricService.sendMetricApplication(application);
        return "Successfully published message..!";
    }

    @PostMapping(value = "/publish/metrics")
    public Map<String, Object> sendMetricSystemObjectToKafkaTopic(@RequestBody MetricSystem metricSystem) {
        producerMetricService.sendMetricSystem(metricSystem);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Successfully published System metrics..!");
        map.put("payload", metricSystem);

        return map;
    }

}
