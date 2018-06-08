package org.usfirst.frc.team3452.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {
	private UsbCamera mCamera0, mCamera1;
	private VideoSink server;

	public void initHardware() {
		mCamera0 = CameraServer.getInstance().startAutomaticCapture(0);
		mCamera0.setResolution(320, 240);
		mCamera0.setFPS(30);
		mCamera0.setExposureManual(35);

//		mCamera1 = CameraServer.getInstance().startAutomaticCapture(1);
//		mCamera1.setResolution(180, 120);
//		mCamera1.setFPS(30);
//		mCamera1.setExposureManual(50);

		server = CameraServer.getInstance().getServer();
		server.setSource(mCamera0);
	}

	public void camSwitch(int cameraswitch) {
		switch (cameraswitch) {
		case 0:
			server.setSource(mCamera0);
			break;
		case 1:
			server.setSource(mCamera1);
			break;
		default:
			System.out.println("Invalid camera selection");
			break;
		}
	}

	public void camExposure(int camera, int exposure) {
		switch (camera) {
		case 0:
			mCamera0.setExposureManual(exposure);
			break;
		case 1:
			mCamera1.setExposureManual(exposure);
			break;
		default:
			System.out.println("Invalid camera selection");
			break;
		}
	}

	public void initDefaultCommand() {
	}
}