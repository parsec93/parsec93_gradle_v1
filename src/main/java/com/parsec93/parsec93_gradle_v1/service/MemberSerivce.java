package com.parsec93.parsec93_gradle_v1.service;

import com.parsec93.parsec93_gradle_v1.domain.Member;
import com.parsec93.parsec93_gradle_v1.repository.MemberRepository;
import com.parsec93.parsec93_gradle_v1.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberSerivce {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
