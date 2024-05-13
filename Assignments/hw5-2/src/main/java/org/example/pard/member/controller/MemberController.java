package org.example.pard.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.service.MemberService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pard")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("") // POST /pard post 요청을 처리하는 메서드
    public String createMember(@RequestBody MemberCreateDTO dto) {
        memberService.createMember(dto);
        return "파드에 가입을 축하드립니다.";
    }  // MemberCreateDTO를 받아 Member로 변환 후 저장
/*
    @GetMapping("") // GET /pard get 요청을 처리하는 메서드
    public List<MemberReadDTO> findMember(@RequestParam(required = false) String part) {
        if (StringUtils.hasText(part)) { // 파트가 있을 경우 파트에 따라 멤버를 조회
            return memberService.findByPart(part);
        } // 파트가 없을 경우 모든 멤버 조회
        return memberService.findAll();
    }

 */
    @GetMapping("") // GET /pard get 요청을 처리하는 메서드
    public List<MemberReadDTO> findMember(@RequestParam(required = false) String part) {
        List<MemberReadDTO> members;
        if (StringUtils.hasText(part)) { // 파트가 있을 경우 파트에 따라 멤버를 조회
            members = memberService.findByPart(part);
            return members;
        } // 파트가 없을 경우 모든 멤버 조회
        members = memberService.findAll();
        members.sort(Comparator.comparing(MemberReadDTO::getAge));
        return members;
    }

    @GetMapping("/{id}") // GET /pard/{id} get 요청을 처리하는 메서드
    public MemberReadDTO findById(@PathVariable Long id) {
        return memberService.findById(id);
    } // id로 조회 후 MemberReadDTO로 변환

    @DeleteMapping("/{id}") // DELETE /pard/{id} delete 요청을 처리하는 메서드
    public String deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return "삭제됨";
    } // id로 삭제

    @PatchMapping("/{id}")
    public String updateById(@PathVariable Long id, @RequestBody MemberCreateDTO dto) {
        memberService.updateById(id, dto);
        return "수정됨";
    }
}
