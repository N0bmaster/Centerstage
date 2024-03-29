package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

/*
 * TODO: Tune or adjust the following constants to fit your robot https://192.168.49.1:8080/dash).
 */
@Config
public class DriveConstants {

    public static final double TICKS_PER_REV = 537.6;
    public static final double MAX_RPM = 312;

    public static final boolean RUN_USING_ENCODER = false;
    public static PIDFCoefficients MOTOR_VELO_PID = new PIDFCoefficients(0, 0, 0,
            getMotorVelocityF(MAX_RPM / 60 * TICKS_PER_REV));
    public static double WHEEL_RADIUS = 1.8898; // in
    public static double GEAR_RATIO = 1; // output (wheel) speed / input (motor) speed
    public static double TRACK_WIDTH = 15.2; // in 14 original
//    public static double kV = 1.0 / rpmToVelocity(MAX_RPM);
    public static double kV = 0.0196;
    public static double kA = 0.00315;
    public static double kStatic = 0.0225;
    public static double MAX_VEL = 50;
    public static double MAX_ACCEL = 50;
    public static double MAX_ANG_VEL = Math.toRadians(200);
    public static double MAX_ANG_ACCEL = Math.toRadians(200);
    public static RevHubOrientationOnRobot.LogoFacingDirection LOGO_FACING_DIR = RevHubOrientationOnRobot.LogoFacingDirection.LEFT;
    public static RevHubOrientationOnRobot.UsbFacingDirection USB_FACING_DIR = RevHubOrientationOnRobot.UsbFacingDirection.UP;

    public static double encoderTicksToInches(double ticks) {
        return WHEEL_RADIUS * 2 * Math.PI * GEAR_RATIO * ticks / TICKS_PER_REV;
    }

    public static double rpmToVelocity(double rpm) {
        return rpm * GEAR_RATIO * 2 * Math.PI * WHEEL_RADIUS / 60.0;
    }

    public static double getMotorVelocityF(double ticksPerSecond) {
        // see https://docs.google.com/document/d/1tyWrXDfMidwYyP_5H4mZyVgaEswhOC35gvdmP-V-5hA/edit#heading=h.61g9ixenznbx
        return 32767 / ticksPerSecond;
    }
}