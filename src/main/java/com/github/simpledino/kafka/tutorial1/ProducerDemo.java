package com.github.simpledino.kafka.tutorial1;

import com.sun.istack.internal.Nullable;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {


        String bootstrapServers = "127.0.0.1:9092";
        //create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        //create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        //create a producer recode
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("first_topic","hello world");

        //send data
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
