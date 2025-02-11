package org.firstinspires.ftc.teamcode;

/**
 * Created by Derek Williams on 10/12/2016.
 */

public class TurnState extends State{
    protected double power;
    protected double initialEncoderPosition;

    TurnState(String name, double power){
        this.name = name;
        this.power = power;
    }

    public double getProgress() {
        return Math.abs(getStateMachine().robot.getDrivePosition() - initialEncoderPosition);
    }

    @Override
    public void start() {
        initialEncoderPosition = getStateMachine().robot.getDrivePosition();
        getStateMachine().robot.setRightDrivePower(power);
        getStateMachine().robot.setLeftDrivePower(-power);
    }

    @Override
    public void loop() {
        getStateMachine().robot.telemetry.addData(name, String.format("Driven %f encoder counts", getProgress()));
    }

    @Override
    public void stop() {
        getStateMachine().robot.stopDriveMotors();
    }
}
