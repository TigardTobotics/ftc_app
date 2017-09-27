package org.firstinspires.ftc.teamcode.opmodes2016;

import org.firstinspires.ftc.teamcode.statemachines.Transition;

/**
 * Created by Derek Williams of team 3965 on 2/18/2017.
 */

public class DriveWithHeadingState extends VelocityVortexState {
    protected double turnPower;
    protected double drivePower;
    protected int threshold = 1;
    protected int targetHeading = 0;

    protected double initialEncoderPosition;

    DriveWithHeadingState(String name, double drivePower, /*double turnPower,*/ int targetHeading, Transition... transitions) {
        super(name, transitions);
        this.drivePower = drivePower;
        this.turnPower = 2*drivePower;//turnPower;
        this.targetHeading = targetHeading;
    }

    @Override
    public double getProgress() {
        //return Math.abs(getRobot().getDrivePosition() - initialEncoderPosition);
        return 0.0;
    }

    @Override
    public void onEntry() {
        super.onEntry();
        //initialEncoderPosition = getRobot().getDrivePosition();
    }

    @Override
    public void doState() {
        //getRobot().telemetry.addData("Heading", getSensorModule().getHeading());


        //double error = (getSensorModule().getHeadingError(targetHeading) / 180.0);

        //getRobot().telemetry.addData("Error", error);

        //getRobot().setRightDrivePower(drivePower-turnPower*error);
        //getRobot().setLeftDrivePower(drivePower+turnPower*error);
    }

    @Override
    public void onExit() {
        super.onExit();
        //getRobot().stopDriveMotors();
    }
}
