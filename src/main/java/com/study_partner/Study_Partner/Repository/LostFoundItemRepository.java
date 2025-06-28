package com.study_partner.Study_Partner.Repository;

import com.study_partner.Study_Partner.Entity.LostFoundItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LostFoundItemRepository extends JpaRepository<LostFoundItem, UUID> {
}
