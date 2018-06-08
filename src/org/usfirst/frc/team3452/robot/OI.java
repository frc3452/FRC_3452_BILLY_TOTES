
package org.usfirst.frc.team3452.robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3452.robot.commands.drive.ResetGyro;
import org.usfirst.frc.team3452.robot.commands.drive.ToggleRelative;
import org.usfirst.frc.team3452.robot.commands.elevator.ElevatorTime;

public class OI {
	public static Joystick driverJoy = new Joystick(0);

	@SuppressWarnings("unused")
	private static Button driverJoyA, driverJoyB, driverJoyX, driverJoyY, driverJoyLB, driverJoyRB, driverJoyBack,
			driverJoyStart, driverJoyLClick, driverJoyRClick;

	public static void init() {
		buttonInit();

        /* DRIVER JOY */
		driverJoyLB.whenPressed(new ResetGyro());
		driverJoyRB.whenPressed(new ToggleRelative(-1));

		driverJoyA.whileHeld(new ElevatorTime(1, 0.1));
		driverJoyY.whileHeld(new ElevatorTime(-1, 0.1));
	}

	private static void buttonInit() {
		driverJoy = new Joystick(0);
		driverJoyA = new JoystickButton(driverJoy, 1);
		driverJoyB = new JoystickButton(driverJoy, 2);
		driverJoyX = new JoystickButton(driverJoy, 3);
		driverJoyY = new JoystickButton(driverJoy, 4);
		driverJoyLB = new JoystickButton(driverJoy, 5);
		driverJoyRB = new JoystickButton(driverJoy, 6);
		driverJoyBack = new JoystickButton(driverJoy, 7);
		driverJoyStart = new JoystickButton(driverJoy, 8);
		driverJoyLClick = new JoystickButton(driverJoy, 9);
		driverJoyRClick = new JoystickButton(driverJoy, 10);

	}
	public static void rumble(double intensity) {
			driverJoy.setRumble(RumbleType.kLeftRumble, intensity);
			driverJoy.setRumble(RumbleType.kRightRumble, intensity);
		}
}
