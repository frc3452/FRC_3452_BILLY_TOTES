package org.usfirst.frc.team3452.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3452.robot.Robot;

public class DriveTime extends Command {
	private double m_x, m_y, m_z, m_time;
	private boolean c_rel, i_rel;

	public DriveTime(double x, double y, double z, boolean isRelative, double time) {
		requires(Robot.drive);
		
		m_x = x;
		m_y = y;
		m_z = z;
		c_rel = isRelative;
	}

	protected void initialize() {
		setTimeout(m_time);
		i_rel = Robot.drive.m_isRelative;
		Robot.drive.m_isRelative = c_rel;
	}

	protected void execute() {
		Robot.drive.Mecanum(m_x, m_y, m_z);
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.drive.Mecanum(0, 0, 0);
		Robot.drive.m_isRelative = i_rel;
	}

	protected void interrupted() {
		end();
	}
}
