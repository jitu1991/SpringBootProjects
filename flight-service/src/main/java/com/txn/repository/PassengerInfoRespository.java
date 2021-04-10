package com.txn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.txn.entity.PassengerInfo;

public interface PassengerInfoRespository extends JpaRepository<PassengerInfo, Long> {

}
