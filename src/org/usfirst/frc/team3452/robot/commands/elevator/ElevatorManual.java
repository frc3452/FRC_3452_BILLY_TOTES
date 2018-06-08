package org.usfirst.frc.team3452.robot.commands.elevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3452.robot.Robot;

public class ElevatorManual extends Command {
	
	private Joystick m_joy;

	public ElevatorManual(Joystick joy) {
		requires(Robot.elevator);
		
		m_joy = joy;
	}

	protected void initialize() {

	}

	protected void execute() {
		Robot.elevator.manual(m_joy);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.elevator.manual(0);
	}

	protected void interrupted() {
		end();
	}
}
