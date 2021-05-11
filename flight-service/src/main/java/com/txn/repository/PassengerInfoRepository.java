package com.txn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.txn.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
