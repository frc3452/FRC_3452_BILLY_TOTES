package org.usfirst.frc.team3452.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3452.robot.OI;

public class Elevator extends Subsystem {

	Jaguar Elev1, Elev2;

	public void initHardware() {
		Elev1 = new Jaguar(Constants.ELEVATOR_1);
		Elev2 = new Jaguar(Constants.ELEVATOR_2);

		Elev1.setInverted(Constants.ELEVATOR_1_INVERT);
		Elev2.setInverted(Constants.ELEVATOR_2_INVERT);
	}

	public void initDefaultCommand() {
	}

	public void manual(double speed) {
		Elev1.set(speed);
		Elev2.set(speed);
	}

	public void manual(Joystick joy) {
		if (joy == OI.driverJoy)
		{
			Elev1.set(joy.getRawAxis(5));
			Elev2.set(joy.getRawAxis(5));
		} else {
			Elev1.set(joy.getRawAxis(1));
			Elev2.set(joy.getRawAxis(1));
		}
	}

	private static class Constants {
		public static final int ELEVATOR_1 = 5, ELEVATOR_2 = 4;
		public static final boolean ELEVATOR_1_INVERT = true, ELEVATOR_2_INVERT = true;
	}

}
