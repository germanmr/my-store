package com.mycompany.mystore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class DataBaseConfiguration {

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
        // We log connection properties
        System.out.println("Database: " + redisConnectionFactory().getDatabase());
        System.out.println("HostName: " + redisConnectionFactory().getHostName());
        System.out.println("PassWord: " + redisConnectionFactory().getPassword());
        System.out.println("Client Name: " + redisConnectionFactory().getClientName());
        System.out.println("Port: " + redisConnectionFactory().getPort());

        int database = redisConnectionFactory().getDatabase();
        String hostName = redisConnectionFactory().getHostName();
        String password = redisConnectionFactory().getPassword();
        String clientName = redisConnectionFactory().getClientName();
        int port = redisConnectionFactory().getPort();

        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }

}