package com.db.demo;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.db.demo.algoteam.Algo;
import com.db.demo.algoteam.SignalHandler;
import com.db.demo.model.Action;
import com.db.demo.model.Signal;

@Component
public class Application implements SignalHandler {
	private final Algo algo;
	private static HashMap<Integer, Signal> signalInfoMap = new HashMap<>();;

	public Application() {
		this.algo = new Algo();
	}

	@Override
	public void handleSignal(int signalId) {
		Signal signal = signalInfoMap.get(signalId);

		// Set Algo Params and Perform actions
		if (signal != null) {
			if (signal.getParams() != null) {
				for (HashMap.Entry<String, Integer> entry : signal.getParams().entrySet()) {
					algo.setAlgoParam(Integer.parseInt(entry.getKey()), entry.getValue());
				}
			}

			if (signal.getActions() != null) {
				for (Action action : signal.getActions()) {
					performAction(action.getAction());
				}
			}
		}
		algo.doAlgo();
		
		System.out.println("----------> signal process completed");
	}

	private void performAction(String action) {

		// Add more cases for additional actions if needed
		switch (action) {
		case "setUp":
			algo.setUp();
			break;
		case "performCalc":
			algo.performCalc();
			break;
		case "submitToMarket":
			algo.submitToMarket();
			break;
		case "reverse":
			algo.reverse();
			break;
		default:
			algo.cancelTrades();
			break;
		}
	}

	public void addSignalInfo(Signal signal) {
		signalInfoMap.put(signal.getSignalId(), signal);
	}
}