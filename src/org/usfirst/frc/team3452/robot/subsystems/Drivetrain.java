package org.usfirst.frc.team3452.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3452.robot.commands.drive.DriveTele;

public class Drivetrain extends Subsystem {
	// PDP
	public PowerDistributionPanel pdp = new PowerDistributionPanel(0);

	// DRIVETRAIN
	private Jaguar L1, L2, R1, R2;

	// ROBOT DRIVE OBJECT
	private MecanumDrive robotDrive;

	// GYRO
	public AHRS Gyro;

	// variable init
	public double m_modify = 1;
	public boolean m_isRelative = false;

	public void initHardware() {

		L1 = new Jaguar(Constants.DRV_L1);
		L2 = new Jaguar(Constants.DRV_L2);
		R1 = new Jaguar(Constants.DRV_R1);
		R2 = new Jaguar(Constants.DRV_R2);

		L1.setInverted(Constants.DRV_L1_INV);
		L2.setInverted(Constants.DRV_L2_INV);
		R1.setInverted(Constants.DRV_R1_INV);
		R2.setInverted(Constants.DRV_R2_INV);

		robotDrive = new MecanumDrive(L1, L2, R1, R2);

		Gyro = new AHRS(SPI.Port.kMXP);

		robotDrive.setDeadband(0.08);
		robotDrive.setSafetyEnabled(true);

		Gyro.reset();

		robotDrive.setSubsystem("Drive train");
		pdp.setSubsystem("Drive train");

		L1.setSubsystem("Drive train");
		L2.setSubsystem("Drive train");
		R1.setSubsystem("Drive train");
		R2.setSubsystem("Drive train");

		L1.setName("L1");
		L2.setName("L2");
		R1.setName("R1");
		R2.setName("R2");
	}

	public void LoggerUpdate() {
		SmartDashboard.putNumber("NavX Angle", Gyro.getAngle());
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveTele());
	}

	public void Mechanum(Joystick joy) {
		Mecanum(joy.getRawAxis(1), -joy.getRawAxis(4), (joy.getRawAxis(2) - joy.getRawAxis(3)));
//		Mecanum(joy.getRawAxis(1), -joy.getRawAxis(0), -joy.getRawAxis(4));
//		if (m_isRelative)
//			OI.rumble(1, .1);
//		else
//			OI.rumble(1, 0);
	}

	public void Mecanum(double x, double y, double z) {
		if (m_isRelative)
			robotDrive.driveCartesian(x, y, z, Gyro.getFusedHeading());
		else
			robotDrive.driveCartesian(x, y, z, 0);
	}

	public static class Constants {
		public static final int DRV_L1 = 8, DRV_L2 = 9, DRV_R1 = 7, DRV_R2 = 6;
		public static final boolean DRV_L1_INV = true, DRV_L2_INV = false, DRV_R1_INV = false, DRV_R2_INV = true;
	}

}
