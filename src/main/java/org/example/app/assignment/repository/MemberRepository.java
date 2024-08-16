package org.example.app.assignment.repository;

import org.example.app.assignment.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByMemberId(Long memberId);

    boolean existsByUpdatedAtAndUsername(LocalDate updatedAt, String username);

    boolean existsByPassword(String password);

}
