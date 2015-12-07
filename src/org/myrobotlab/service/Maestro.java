package org.myrobotlab.service;

import java.util.ArrayList;

import org.myrobotlab.framework.MRLException;
import org.myrobotlab.framework.Peers;
import org.myrobotlab.framework.Service;
import org.myrobotlab.logging.Level;
import org.myrobotlab.logging.LoggerFactory;
import org.myrobotlab.logging.Logging;
import org.myrobotlab.logging.LoggingFactory;
import org.myrobotlab.service.data.Pin;
import org.myrobotlab.service.interfaces.ArduinoShield;
import org.myrobotlab.service.interfaces.ServoController;
import org.slf4j.Logger;

/**
 * @author GroG http://www.pololu.com/product/1352
 *         http://www.pololu.com/product/1350
 *
 */
public class Maestro extends Service implements ArduinoShield, ServoController {

	private static final long serialVersionUID = 1L;

	public final static Logger log = LoggerFactory.getLogger(Maestro.class);

	public static Peers getPeers(String name) {
		Peers peers = new Peers(name);
		peers.put("serial", "Serial", "Serial service is needed for Pololu");
		return peers;
	}

	public static void main(String[] args) {
		LoggingFactory.getInstance().configure();
		LoggingFactory.getInstance().setLevel(Level.WARN);

		try {

			Maestro template = new Maestro("template");
			template.startService();

			Runtime.createAndStart("gui", "GUIService");
			/*
			 * GUIService gui = new GUIService("gui"); gui.startService();
			 */

		} catch (Exception e) {
			Logging.logError(e);
		}
	}

	public Maestro(String n) {
		super(n);
	}

	@Override
	public boolean attach(Arduino arduino) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] getCategories() {
		return new String[] { "microcontroller" };
	}

	@Override
	public String getDescription() {
		return "used as a general template";
	}

	@Override
	public ArrayList<Pin> getPinList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAttached() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void attach(String name) throws MRLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean detach(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean connect(String port) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean servoAttach(Servo servo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean servoDetach(Servo servo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void servoSweepStart(Servo servo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void servoSweepStop(Servo servo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void servoWrite(Servo servo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void servoWriteMicroseconds(Servo servo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setServoEventsEnabled(Servo servo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setServoSpeed(Servo servo) {
		// TODO Auto-generated method stub
		
	}

}
