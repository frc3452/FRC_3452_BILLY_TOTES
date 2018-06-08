package org.usfirst.frc.team3452.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3452.robot.Robot;

public class ElevatorTime extends Command {

	private double m_speed, m_timeout;

	public ElevatorTime(double speed, double timeout) {
		requires(Robot.elevator);

		m_speed = speed;
		m_timeout = timeout;
	}

	protected void initialize() {
		setTimeout(m_timeout);
	}

	protected void execute() {
		Robot.elevator.manual(m_speed);
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.elevator.manual(0);
	}

	protected void interrupted() {
		end();
	}
}
