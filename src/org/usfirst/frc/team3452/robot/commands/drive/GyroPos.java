package org.usfirst.frc.team3452.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3452.robot.Robot;

public class GyroPos extends Command {
	private double m_gyro, m_target, m_speed, m_precise;

	public GyroPos(double targetangle, double speed, double precise) {
		requires(Robot.drive);

		m_gyro = Robot.drive.Gyro.getFusedHeading();
		m_target = targetangle;
		m_speed = speed;
		m_precise = precise;
	}

	protected void initialize() {
		setTimeout(8);
	}

	protected void execute() {
		m_gyro = Robot.drive.Gyro.getFusedHeading();

		if (m_gyro > 360 && m_gyro > 180) {
			if ((m_gyro < (m_target + 180)) && (m_gyro > m_target)) {
				Robot.drive.Mecanum(0, 0, -m_speed);
			} else {
				Robot.drive.Mecanum(0, 0, m_speed);
			}
		}

		if (m_gyro > 0 && m_gyro < 180) {
			if ((m_gyro > (m_target - 180)) && (m_gyro < m_target)) {
				Robot.drive.Mecanum(0, 0, m_speed);
			} else {
				Robot.drive.Mecanum(0, 0, -m_speed);
			}
		}

	}

	protected boolean isFinished() {
		return ((m_gyro < (m_target + m_precise)) && (m_gyro > (m_target - m_precise))) || isTimedOut();
	}

	protected void end() {
		Robot.drive.Mecanum(0, 0, 0);
	}

	protected void interrupted() {
		end();
	}
}
