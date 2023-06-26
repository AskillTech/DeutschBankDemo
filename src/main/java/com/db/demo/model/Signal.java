package com.db.demo.model;

import java.util.HashMap;
import java.util.List;

public class Signal {

	private int signalId;
	private HashMap<String, Integer> params;
	private List<Action> actions;

	public int getSignalId() {
		return signalId;
	}

	public void setSignalId(int signalId) {
		this.signalId = signalId;
	}

	public HashMap<String, Integer> getParams() {
		return params;
	}

	public void setParams(HashMap<String, Integer> params) {
		this.params = params;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
}
