package org.example.pard.member.service;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.entity.Member;
import org.example.pard.member.repo.MemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepo memberRepo;

    public void createMember(MemberCreateDTO dto) {
        memberRepo.save(new Member().toEntity(dto));
    } // MemberCreateDTO를 받아 Member로 변환 후 저장

    public MemberReadDTO findById(Long id) {
        return new MemberReadDTO().toDTO(memberRepo.findById(id).orElseThrow());
    } // id로 조회 후 MemberReadDTO로 변환

    public List<MemberReadDTO> findAll() {
        return memberRepo.findAll()
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }// 모든 멤버 조회 후 MemberReadDTO로 변환

    public List<MemberReadDTO> findByPart(String part) {
        return memberRepo.findByPart(part)
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList()); //
    }// 파트에 따라 멤버 조회 후 MemberReadDTO로 변환

    public void deleteById(Long id) {
        memberRepo.deleteById(id);
    } // id로 삭제

    public void updateById(Long id, MemberCreateDTO dto) {
        Member member = memberRepo.findById(id).orElseThrow();
        member.updateById(member,dto);
        memberRepo.save(member);
    }
}
