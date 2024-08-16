package org.example.app.assignment.service;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.app.assignment.dto.MemberDTO;
import org.example.app.assignment.entity.MemberEntity;
import org.example.app.assignment.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "/application-test.properties")
@EnableJpaAuditing
class MemberServiceTest {

    private final MemberRepository memberRepository;
    private final MemberEntity memberEntity;

    @Autowired
    public MemberServiceTest(MemberRepository memberRepository,MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
        this.memberRepository = memberRepository;
    }



    @Test
    void createMember() {
        memberEntity.setMemberId(8L);
        memberEntity.setUsername("qowlsrhks");
        memberEntity.setPassword("123456");
        memberEntity.setContents("내용이지");
        memberEntity.setCreatedAt(LocalDate.now());
        memberEntity.setUpdatedAt(LocalDate.now());

        memberRepository.save(memberEntity);

        assertEquals(memberEntity.getMemberId(), 8L);
        assertEquals(memberEntity.getUsername(), "qowlsrhks");
        assertEquals(memberEntity.getPassword(), "123456");
        assertEquals(memberEntity.getContents(), "내용이지");
    }


    @Test
    void selectMember() {
        List<MemberEntity> memberEntities = memberRepository.findAll();
        assertEquals(memberEntities.size(), 5);
    }

    @Test
    void selectOneMember() {
        memberEntity.setMemberId(8L);
        memberEntity.setUsername("qowlsrhks");
        memberEntity.setPassword("123456");
        memberEntity.setContents("내용이지");
        memberEntity.setCreatedAt(LocalDate.now());
        memberEntity.setUpdatedAt(LocalDate.now());

        if (memberRepository.existsByUpdatedAtAndUsername(memberEntity.getUpdatedAt(), "qowlsrhks")) {
            assertEquals(memberEntity.getMemberId(), 8L);
            assertEquals(memberEntity.getUsername(), "qowlsrhks");
            assertEquals(memberEntity.getContents(), "내용이지");
            assertEquals(memberEntity.getCreatedAt(), new Date());
            assertEquals(memberEntity.getUpdatedAt(), new Date());
        }
        if (memberEntity.getMemberId() == 8L) {
            assertEquals(memberEntity.getMemberId(), 8L);
            assertEquals(memberEntity.getUsername(), "qowlsrhks");
            assertEquals(memberEntity.getContents(), "내용이지");
        }
    }

    @Test
    void updateMember() {
        memberEntity.setMemberId(8L);
        memberEntity.setUsername("qowlsrhks");
        memberEntity.setPassword("123456");
        memberEntity.setContents("내용이지");
        memberEntity.setCreatedAt(LocalDate.now());
        memberEntity.setUpdatedAt(LocalDate.now());


        if (memberRepository.existsByPassword("123456")) {
            memberEntity.setUsername("deruco");
            memberEntity.setContents("바뀐 내용이지");
            memberEntity.setUpdatedAt(LocalDate.now());
            memberRepository.save(memberEntity);

            assertEquals(memberEntity.getMemberId(), 8L);
            assertEquals(memberEntity.getUsername(), "deruco");
            assertEquals(memberEntity.getContents(), "바뀐 내용이지");
            assertEquals(memberEntity.getUpdatedAt(), memberEntity.getUpdatedAt());
        }
    }

    @Test
    void deleteMember() {
        MemberEntity memberEntity = memberRepository.findByMemberId(7L);
        if (memberEntity.getMemberId() == 7L && memberRepository.existsByPassword("123456")) {
            memberRepository.deleteById(memberEntity.getMemberId());
        }
    }
}