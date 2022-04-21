package com.example.hellospring;

import com.example.hellospring.repository.*;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private final EntityManager entityManagerm;
//
//    @Autowired
//    public SpringConfig(EntityManager entityManagerm) {
//        this.entityManagerm = entityManagerm;
//    }
    private final MemberRepository memberRepository;


    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        // JpaRepository 상속받게 만들어줘서 거기서 spring bean에 알아서 등록해줌.
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
//        return new JpaMemberRepository(entityManagerm);
//    }
}
