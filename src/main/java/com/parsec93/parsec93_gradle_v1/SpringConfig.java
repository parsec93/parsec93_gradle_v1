package com.parsec93.parsec93_gradle_v1;

import com.parsec93.parsec93_gradle_v1.aop.TimeTraceAop;
import com.parsec93.parsec93_gradle_v1.repository.*;
import com.parsec93.parsec93_gradle_v1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

/* 이 방법으로 빈을 등록해서 써도 되고 아니면 TimeTraceAop Class 에서 Component 스캔을 사용해도 됨. 현재는 Component 스캔을 사용하기로 함
   @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
*/

//    @Bean
//    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemeberRepository(dataSource);
        //return new JpaMemberRepository(em);

//    }
}
