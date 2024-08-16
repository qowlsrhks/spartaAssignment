package org.example.app.assignment.service;

import org.example.app.assignment.dto.MemberDTO;
import org.example.app.assignment.entity.MemberEntity;
import org.example.app.assignment.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    생성
    public MemberEntity createMember(MemberDTO memberDTO) {

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(memberDTO.getUsername());
        memberEntity.setPassword(memberDTO.getPassword());
        memberEntity.setContents(memberDTO.getContents());
        memberEntity.setCreatedAt(LocalDate.now());
        memberEntity.setUpdatedAt(LocalDate.now());

        return memberRepository.save(memberEntity);

    }

    //    읽기
    public List<MemberEntity> selectMember() {
        return memberRepository.findAll();
    }

    //    검색
    public MemberEntity selectOneMember(MemberDTO memberDTO) {
        if (memberRepository.existsByUpdatedAtAndUsername(memberDTO.getUpdatedAt(), memberDTO.getUsername())) {
            return memberRepository.findByMemberId(memberDTO.getMemberId());
        }
        return null;
    }


    //    수정
    public Long updateMember(MemberDTO memberDTO) {
        MemberEntity memberEntity = memberRepository.findByMemberId(memberDTO.getMemberId());
        if (memberRepository.existsByPassword(memberDTO.getPassword())) {
            memberEntity.setUsername(memberDTO.getUsername());
            memberEntity.setContents(memberDTO.getContents());
            memberEntity.setUpdatedAt(LocalDate.now());
        }
        return memberRepository.save(memberEntity).getMemberId();
    }

    //    삭제
    public Long deleteMember(MemberDTO memberDTO) {
        if (memberRepository.existsByPassword(memberDTO.getPassword())) {
            memberRepository.deleteById(memberDTO.getMemberId());
        }
        return memberDTO.getMemberId();
    }

}
