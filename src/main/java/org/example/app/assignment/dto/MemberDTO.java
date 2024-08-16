package org.example.app.assignment.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MemberDTO {
    private Long memberId;

    private String username;
    private String password;
    private String contents;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
