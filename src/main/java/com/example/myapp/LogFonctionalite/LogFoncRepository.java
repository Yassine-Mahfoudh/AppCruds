package com.example.myapp.LogFonctionalite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LogFoncRepository  extends JpaRepository<LogFonc,Long> {


    Optional <LogFonc> findLogFoncById(Long id);
}
