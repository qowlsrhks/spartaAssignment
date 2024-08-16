package org.example.app.assignment.controller; 

import org.example.app.assignment.dto.MemberDTO;
import org.example.app.assignment.entity.MemberEntity;
import org.example.app.assignment.repository.MemberRepository;
import org.example.app.assignment.service.MemberService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/app")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    생성
    @PostMapping("/memos/signup")
    public MemberEntity createMemo(@RequestBody MemberDTO memberDTO) {
        return memberService.createMember(memberDTO);
    }

//    읽기
    @GetMapping("/memos")
    public List<MemberEntity> selectMemos() {
        return memberService.selectMember();
    }

//    검색
    @GetMapping("/memos/search")
    public MemberEntity selectOneMemo(@RequestBody MemberDTO memberDTO) {
        return memberService.selectOneMember(memberDTO);
    }

//    수정
    @PostMapping("/memos/update")
    public Long updateMemo(@RequestBody MemberDTO memberDTO) {
        return memberService.updateMember(memberDTO);
    }

//    삭제
    @PostMapping("/memos/delete")
    public Long deleteMemo(@RequestBody MemberDTO memberDTO) {
        return memberService.deleteMember(memberDTO);
    }
}