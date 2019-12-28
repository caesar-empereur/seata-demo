package com.repository;

import com.Account;
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
public interface AccountRepository extends JpaRepository<Account, String> {

    @Transactional
    @Modifying
    @Query(value = "update t_account set balance=balance-?1 where id=?2", nativeQuery = true)
    void reduce(Integer money, String id);
}
