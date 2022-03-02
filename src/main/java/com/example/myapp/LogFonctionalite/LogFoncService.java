package com.example.myapp.LogFonctionalite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogFoncService { public final LogFoncRepository logFoncRepository;
    @Autowired
    public LogFoncService(LogFoncRepository logFoncRepository) {
        this.logFoncRepository = logFoncRepository;
    }

    public List<LogFonc> getLogFoncs(){
        return logFoncRepository.findAll();
    }

    public LogFonc findLogFoncById(Long id) {
        return logFoncRepository.findLogFoncById(id)
                .orElseThrow(() -> new IllegalStateException("LogFonc by id " + id + " was not found"));
    }

}
