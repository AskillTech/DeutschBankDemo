package com.db.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.db.demo.algoteam.SignalHandler;

@RestController
class SignalController {
	
	@Autowired
    private final SignalHandler signalHandler;

    public SignalController(SignalHandler signalHandler) {
        this.signalHandler = signalHandler;
    }
    
    @GetMapping("/signal/{signal}")
    public void receiveSignal(@PathVariable int signal) {
        signalHandler.handleSignal(signal);
    }
    
}