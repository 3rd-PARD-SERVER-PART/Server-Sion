package org.example.pard.member.repo;

import org.example.pard.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepo extends JpaRepository<Member, Long> {
   List<Member> findByPart(String part); // 파트에 따라 멤버를 조회하는 메서드 추가
}
