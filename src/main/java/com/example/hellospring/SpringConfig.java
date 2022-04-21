package com.example.hellospring;

import com.example.hellospring.repository.*;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final EntityManager entityManagerm;

    @Autowired
    public SpringConfig(EntityManager entityManagerm) {
        this.entityManagerm = entityManagerm;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
        return new JpaMemberRepository(entityManagerm);
    }
}
