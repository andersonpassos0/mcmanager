package com.mastersystem.mcmanager.infrastructure.mapper;

import com.mastersystem.mcmanager.application.dto.request.MemberRequest;
import com.mastersystem.mcmanager.application.dto.request.MemberUpdateRequest;
import com.mastersystem.mcmanager.application.dto.response.MemberResponse;
import com.mastersystem.mcmanager.domain.model.Member;
import com.mastersystem.mcmanager.infrastructure.entity.MemberEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberEntity toEntity(Member member);
    Member toModel(MemberEntity entity);

    MemberEntity toEntity(MemberRequest request);
    MemberResponse toResponse(MemberEntity entity);

    MemberEntity toEntity(MemberUpdateRequest request);
}
