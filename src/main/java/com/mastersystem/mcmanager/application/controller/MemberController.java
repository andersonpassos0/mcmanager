package com.mastersystem.mcmanager.application.controller;

import com.mastersystem.mcmanager.application.dto.request.MemberRequest;
import com.mastersystem.mcmanager.application.dto.request.MemberUpdateRequest;
import com.mastersystem.mcmanager.application.dto.response.MemberResponse;
import com.mastersystem.mcmanager.domain.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@RequestBody MemberRequest request){
        System.out.println(request.getBairro());
        return ResponseEntity.ok(memberService.createMember(request));
    }

    @GetMapping
    public List<MemberResponse> findAllMembers(){
        return memberService.findAllMembers();
    }

    @GetMapping(value = "/findById/{id}")
    public MemberResponse findMemberById(@PathVariable Long id){
        return memberService.findMemberById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long id, @RequestBody MemberUpdateRequest memberUpdateRequest){
        return memberService.updateMember(id, memberUpdateRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
