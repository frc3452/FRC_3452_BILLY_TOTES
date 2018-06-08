package org.usfirst.frc.team3452.robot.commands.drive;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team3452.robot.Robot;

/**
 *
 */
public class ToggleRelative extends InstantCommand {

	private int m_rel;

	public ToggleRelative(int relative) {
		super();

		m_rel = relative;
	}

	protected void initialize() {
		if (m_rel == -1)
			Robot.drive.m_isRelative = !Robot.drive.m_isRelative;
		else if (m_rel == 0)
			Robot.drive.m_isRelative = false;
		else if (m_rel == 1)
			Robot.drive.m_isRelative = true;
		
		System.out.println("WARNING Relative: " + Robot.drive.m_isRelative);
		
	}
}
