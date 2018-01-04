package org.firstinspires.ftc.teamcode.controllers;

import com.qualcomm.hardware.motors.TetrixMotor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Katrina on 12/30/2017.
 */

public class BlockRolling extends HardwareController implements IBlockLift {
    // Declare hardware objects
    private DcMotor liftMotor;
    private Servo rightClamp;
    private Servo leftClamp;

    // set servo positions
    private static final double servoHold = 0.5;
    private static final double servoRelease = 0.0;
    private static final double servoAcquire = 1.0;

    private double initialEncoderPos;

    /* Preset Positions:

     */


    /**
     * Constructor
     * @param liftMotor
     * @param rightClamp
     * @param leftClamp
     */
    public BlockRolling(DcMotor liftMotor, Servo rightClamp, Servo leftClamp) {
        this.liftMotor = liftMotor;
        this.liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.rightClamp = rightClamp;
        this.leftClamp = leftClamp;
    }

    @Override
    public void init() {
        initialEncoderPos = liftMotor.getCurrentPosition();
        hold();
        super.init();
    }

    @Override
    public void loop() {
        super.loop();
        Robot.telemetry.addData("lift pos", getLiftPos());
    }

    public void acquire() {
        rightClamp.setPosition(servoAcquire);
        leftClamp.setPosition(servoRelease);
    }

    public void hold() {
        rightClamp.setPosition(servoHold);
        leftClamp.setPosition(servoHold);
    }

    public void release() {
        rightClamp.setPosition(servoRelease);
        leftClamp.setPosition(servoAcquire);
    }

    public void turnClockwise() {
        rightClamp.setPosition(servoAcquire);
        leftClamp.setPosition(servoAcquire);
    }

    public void turnCounterClockwise() {
        rightClamp.setPosition(servoRelease);
        leftClamp.setPosition(servoRelease);
    }

    public void setPos() {
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setTargetPosition(4000);
    }

    public void lift(double power) {
        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotor.setPower(power);
    }

    public void reset() {
        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        liftMotor.setPower(0.0);
    }

    private double getLiftPos() {
        return Math.abs(liftMotor.getCurrentPosition()-initialEncoderPos);
    }
}
