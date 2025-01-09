package com.mastersystem.mcmanager.domain.service;

import com.mastersystem.mcmanager.application.dto.request.MemberRequest;
import com.mastersystem.mcmanager.application.dto.request.MemberUpdateRequest;
import com.mastersystem.mcmanager.application.dto.response.MemberResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    MemberResponse createMember(MemberRequest request);
    List<MemberResponse> findAllMembers();
    MemberResponse findMemberById(Long id);
    ResponseEntity<MemberResponse> updateMember(Long id, MemberUpdateRequest memberUpdateRequest);
    void deleteMember(Long id);
}
