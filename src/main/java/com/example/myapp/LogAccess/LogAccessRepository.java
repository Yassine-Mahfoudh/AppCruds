package com.example.myapp.LogAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogAccessRepository
        extends JpaRepository<LogAccess,Long> {
    @Query("SELECT h FROM LogAccess h where h.heureentree = ?1")
    Optional<LogAccess> findLogAccessByHeureentree(String heureentree);

    Optional <LogAccess> findLogAccessById(Long id);
}
