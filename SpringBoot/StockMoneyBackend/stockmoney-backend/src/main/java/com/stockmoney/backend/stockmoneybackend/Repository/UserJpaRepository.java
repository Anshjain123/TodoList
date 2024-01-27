package com.stockmoney.backend.stockmoneybackend.Repository;


import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<Id, Long> {

}
