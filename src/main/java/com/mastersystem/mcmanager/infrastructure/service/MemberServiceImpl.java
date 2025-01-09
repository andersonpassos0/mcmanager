package com.mastersystem.mcmanager.infrastructure.service;

import com.mastersystem.mcmanager.application.dto.request.MemberRequest;
import com.mastersystem.mcmanager.application.dto.request.MemberUpdateRequest;
import com.mastersystem.mcmanager.application.dto.response.MemberResponse;
import com.mastersystem.mcmanager.domain.service.MemberService;
import com.mastersystem.mcmanager.infrastructure.entity.MemberEntity;
import com.mastersystem.mcmanager.infrastructure.mapper.MemberMapper;
import com.mastersystem.mcmanager.infrastructure.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public MemberResponse createMember(MemberRequest request) {
        log.info("[start] MemberServiceImpl - createMember");
        MemberEntity entity = memberMapper.toEntity(request);
        MemberEntity saved = memberRepository.save(entity);
        MemberResponse response = memberMapper.toResponse(saved);
        log.info("[finish] MemberServiceImpl - createMember");
        return response;
    }

    @Override
    public List<MemberResponse> findAllMembers() {
        log.info("[start] MemberServiceImpl - findAllMembers");
        List<MemberEntity> membersList = memberRepository.findAll();
        List<MemberResponse> savedMemberList = membersList.stream()
                        .map(memberMapper::toResponse)
                                .toList();
        log.info("[finish] MemberServiceImpl - findAllMembers");
        return savedMemberList;
    }

    @Override
    public MemberResponse findMemberById(Long id) {
        log.info("[start] MemberServiceImpl - findMemberById");
        Optional<MemberEntity> entity = memberRepository.findById(id);
        MemberResponse response = entity
                        .map(memberMapper::toResponse)
                        .orElseThrow(() -> new EntityNotFoundException("Member with id " + id + " not found"));
        log.info("[finish] MemberServiceImpl - findMemberById");
        return response;
    }

    @Override
    public ResponseEntity<MemberResponse> updateMember(Long id, MemberUpdateRequest request) {
        log.info("[start] MemberServiceImpl - updateMember");
        MemberEntity entity = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Member with id " + id + " not found"));
        MemberEntity updatedEntity = memberMapper.toEntity(request);
        MemberEntity mergedEntity = entity.updateEntity(updatedEntity);
        MemberEntity savedEntity = memberRepository.save(mergedEntity);
        MemberResponse response = memberMapper.toResponse(savedEntity);
        log.info("[finish] MemberServiceImpl - updateMember");
        return ResponseEntity.ok(response);
    }

    @Override
    public void deleteMember(Long id) {
        log.info("[start] MemberServiceImpl - deleteMember");
        MemberEntity entity = memberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Membro não encontrado com a ID: " + id));
        memberRepository.delete(entity);
        log.info("[finish] MemberServiceImpl - deleteMember");
    }
}
