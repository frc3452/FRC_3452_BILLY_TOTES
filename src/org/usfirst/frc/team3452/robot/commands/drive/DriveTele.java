package org.usfirst.frc.team3452.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3452.robot.OI;
import org.usfirst.frc.team3452.robot.Robot;

public class DriveTele extends Command {

	public DriveTele() {
		requires(Robot.drive);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.drive.Mechanum(OI.driverJoy);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drive.Mecanum(0, 0, 0);
	}

	protected void interrupted() {
		end();
	}
}
