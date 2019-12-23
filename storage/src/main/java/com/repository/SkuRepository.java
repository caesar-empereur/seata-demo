package com.repository;

import com.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/11/30.
 */
@Repository
public interface SkuRepository extends JpaRepository<Sku, String> {

    @Transactional
    @Modifying
    @Query(value = "update sku set num=num-?1 where id=?2", nativeQuery = true)
    void reduce(Integer num, String id);
}
