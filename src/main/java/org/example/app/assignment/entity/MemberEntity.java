package org.example.app.assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Component
@Table(name = "MEMBER_TBL")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String contents;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;


}
