package edu.msudenver.repository;

import edu.msudenver.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.email = ?1")
    Account findByEmail(String email);

    @Query("SELECT a FROM Account a WHERE a.gamerTag = ?1")
    Account findBygamerTag(String gamerTag);
}