package com.example.myapp.LogFonctionalite;

import com.example.myapp.Fonctionalite.Fonctionalite;
import com.example.myapp.Fonctionalite.FonctionaliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/logfonc")
public class LogFoncController {
        private final LogFoncService logFoncService;
        @Autowired
        public LogFoncController(LogFoncService logFoncService) {
            this.logFoncService =  logFoncService;
        }

        @GetMapping
        public List<LogFonc> getLogFoncs() {
            return logFoncService.getLogFoncs();
        }


        @GetMapping("/find/{id}")
        public ResponseEntity<LogFonc> getLogFoncById (@PathVariable("id") Long id) {
            LogFonc logFonc = logFoncService.findLogFoncById(id);
            return new ResponseEntity<>(logFonc, HttpStatus.OK);
        }
}
