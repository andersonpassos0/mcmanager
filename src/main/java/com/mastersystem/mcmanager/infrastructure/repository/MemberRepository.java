package com.mastersystem.mcmanager.infrastructure.repository;

import com.mastersystem.mcmanager.infrastructure.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
