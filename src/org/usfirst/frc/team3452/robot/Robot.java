package org.usfirst.frc.team3452.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team3452.robot.commands.auton.Auton;
import org.usfirst.frc.team3452.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3452.robot.subsystems.Elevator;

public class Robot extends TimedRobot {
    public static final Drivetrain drive = new Drivetrain();
    public static final Elevator elevator = new Elevator();

    public static OI _oi;

    Command autonomousCommand = null;

    @Override
    public void robotInit() {
        Robot.drive.initHardware();
        Robot.elevator.initHardware();
//		Robot.camera.initHardware();

        _oi = new OI();
        OI.init();

        autonomousCommand = (new Auton());
    }

    public void robotPeriodic(){
        Robot.drive.LoggerUpdate();
    }

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
