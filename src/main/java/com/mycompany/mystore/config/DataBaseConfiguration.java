package com.mycompany.mystore.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class DataBaseConfiguration {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        // This default constructor utilices hardcode connection properties
//        return new LettuceConnectionFactory();

        // In docker network we connect using the container name in this case: "redis"
//        String host = "localhost";

        RedisProperties redisProperties = redisProperties();

        String host = redisProperties.getHost();
        int port = redisProperties.getPort();

        // improvement, Use another constructor with all the properties
        // from file property
        return new LettuceConnectionFactory(host, port);

    }


    /**
     * @return
     */
    @Bean
    public RedisTemplate<?, ?> redisTemplate() {

        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();

        LettuceConnectionFactory redisConnectionFactory = redisConnectionFactory();

        // We log connection properties
        System.out.println("Database: " + redisConnectionFactory.getDatabase());
        System.out.println("HostName: " + redisConnectionFactory.getHostName());
        System.out.println("PassWord: " + redisConnectionFactory.getPassword());
        System.out.println("Client Name: " + redisConnectionFactory.getClientName());
        System.out.println("Port: " + redisConnectionFactory.getPort());

        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    @Primary
    public RedisProperties redisProperties() {
        return new RedisProperties();
    }

}