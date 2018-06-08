package org.usfirst.frc.team3452.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team3452.robot.commands.drive.DriveTime;

/**
 *
 */
public class Auton extends CommandGroup {

    public Auton() {
    	addSequential(new DriveTime(1, 0, 0, true, 1));
    	addSequential(new DriveTime(0, 0, 0, false, 1));
    	addSequential(new DriveTime(0, 1, 0, true, 1));
    }
}
