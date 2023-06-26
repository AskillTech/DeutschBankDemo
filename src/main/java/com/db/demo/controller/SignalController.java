package com.db.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.demo.Application;
import com.db.demo.algoteam.SignalHandler;
import com.db.demo.model.Signal;

@RestController
public class SignalController {

	@Autowired
  private SignalHandler signalHandler;

	/**
	 * POST endpoint to receive a trading signal and process it.
	 * 
	 * @param signal -> signalId, params and actions
	 * @return ResponseEntity success massage of signal processing
	 */
	@PostMapping("/signal")
	public ResponseEntity<String> receiveSignal(@RequestBody Signal signal) {
		try {
			Application application = new Application();
			application.addSignalInfo(signal);
			signalHandler.handleSignal(signal.getSignalId());
			String responseMessage = "Signal processed successfully";
			return ResponseEntity.ok(responseMessage);
		} catch (Exception e) {
			String errorMessage = "Error processing the signal: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}
}