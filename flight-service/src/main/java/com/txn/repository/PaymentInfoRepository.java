package com.txn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.txn.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}
