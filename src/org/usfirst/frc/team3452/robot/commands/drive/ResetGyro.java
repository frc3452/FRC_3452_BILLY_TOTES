package org.usfirst.frc.team3452.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3452.robot.Robot;

public class ResetGyro extends Command {

	public ResetGyro() {
		requires(Robot.drive);
	}

	protected void initialize() {
		setTimeout(0.1);
		Robot.drive.Gyro.reset();
		System.out.println("WARNING Gyro Reset");
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}
