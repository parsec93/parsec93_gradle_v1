package com.parsec93.parsec93_gradle_v1.service;

import com.parsec93.parsec93_gradle_v1.domain.Member;
import com.parsec93.parsec93_gradle_v1.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    //MemberService memberService = new MemberService();
    //MemoryMemberRepository memberRepsotiory = new MemoryMemberRepository();

    //동일한 repository 테스트를 위해 위 라인을 아래로 변경 + BeforeEach 를 추가
    MemberService memberService;
    MemoryMemberRepository memberRepsotiory;

    @BeforeEach
    public void beforeEach(){
        memberRepsotiory = new MemoryMemberRepository();
        memberService = new MemberService(memberRepsotiory);
    }

    @AfterEach
    public void afterEach(){
        memberRepsotiory.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");


        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*        try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            //e.printStackTrace();
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/


        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}