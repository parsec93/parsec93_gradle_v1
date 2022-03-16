package com.parsec93.parsec93_gradle_v1;

import com.parsec93.parsec93_gradle_v1.repository.MemberRepository;
import com.parsec93.parsec93_gradle_v1.repository.MemoryMemberRepository;
import com.parsec93.parsec93_gradle_v1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
