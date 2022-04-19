package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemoryMemberRepository repository;
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        repository =  new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        String myName = "surin";
        member.setName(myName);

        // when
        Long savedId = memberService.join(member);

        // then
        Optional<Member> result = memberService.findOne(savedId);
        Assertions.assertThat(savedId).isEqualTo(result.get().getId());
    }

    @Test
    public void duplicateMemberException() {
        // given
        Member member_new1 = new Member();
        member_new1.setName("surin1");

        Member member_new2 = new Member();
        member_new2.setName("surin1");

        memberService.join(member_new1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member_new2));

        // then
        Assertions.assertThat(e.getMessage()).isEqualTo("Already existing member");
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}