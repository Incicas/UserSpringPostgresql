package com.example.UserSpringPostgresql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, Long> {
}
