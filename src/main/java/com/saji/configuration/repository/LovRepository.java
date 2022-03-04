package com.saji.configuration.repository;

import com.saji.configuration.entities.Lov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface LovRepository extends JpaRepository<Lov, BigInteger> {
    @Modifying
    @Query("update Lov set logicalDeleteIn='Y' where id = ?1")
    void deleteLov(BigInteger id);
}