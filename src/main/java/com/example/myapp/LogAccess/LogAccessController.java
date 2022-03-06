package com.example.myapp.LogAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/logAccess")
public class LogAccessController {
    private final LogAccessService logAccessService;
    @Autowired
    public LogAccessController(LogAccessService logAccessService) {
        this.logAccessService = logAccessService;
    }

    @GetMapping
    public List<LogAccess> getLogAccess() {
        return logAccessService.getLogAccess();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LogAccess> getLogAccessById (@PathVariable("id") Long id) {
        LogAccess logAccess = logAccessService.findLogAccessById(id);
        return new ResponseEntity<>(logAccess, HttpStatus.OK);
    }

    /*@PutMapping(path = "{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String adresse){
        employeeService.updateEmployee(id,nom,adresse);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
