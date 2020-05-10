package org.example.repository;

import org.example.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p WHERE p.ticker = ?1 AND p.date BETWEEN ?2 AND ?3")
    List<Price> filerPrice(String ticker, Date startDate, Date endDate);

    @Transactional
    Long deletePricesByTicker(String ticker);

}