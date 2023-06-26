package com.db.demo;

import com.db.demo.controller.SignalController;
import com.db.demo.model.Action;
import com.db.demo.model.Signal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.db.demo.algoteam.SignalHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class TradingApplicationTests {

		@Autowired
    private SignalController signalController;

    @Mock
    private SignalHandler signalHandler;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testReceiveSignal() {
        Signal signal = new Signal();
        signal.setSignalId(1);
        signal.setParams(new HashMap<>());
        signal.getParams().put("1", 50);
        signal.getParams().put("2", 15);

        Action action1 = new Action();
        action1.setAction("setUp");
        signal.setActions(new ArrayList<>());
        signal.getActions().add(action1);

        Action action2 = new Action();
        action2.setAction("performCalc");
        signal.getActions().add(action2);

        Action action3 = new Action();
        action3.setAction("submitToMarket");
        signal.getActions().add(action3);

        ResponseEntity<String> response = signalController.receiveSignal(signal);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Signal processed successfully", response.getBody());
    }
    
    
    @Test
    void testReceiveSignalWithJson() {
        String jsonSignal = "{\"signalId\":1,\"params\":{\"1\":60},\"actions\":[{\"action\":\"setUp\"},{\"action\":\"performCalc\"},{\"action\":\"submitToMarket\"}]}";
//        String jsonSignal = "{\"signalId\":2,\"params\":{\"1\":80},\"actions\":[{\"action\":\"reverse\"},{\"action\":\"setAlgoParam\"},{\"action\":\"submitToMarket\"}]}";
//        String jsonSignal = "{\"signalId\":3,\"params\":{\"1\":90,\"2\":15},\"actions\":[{\"action\":\"setAlgoParam\"},{\"action\":\"performCalc\"},{\"action\":\"submitToMarket\"}]}";


        ObjectMapper objectMapper = new ObjectMapper();
       
        Signal signal = null;
				try {
					signal = objectMapper.readValue(jsonSignal, Signal.class);
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}

        ResponseEntity<String> response = signalController.receiveSignal(signal);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Signal processed successfully", response.getBody());
    }
}

