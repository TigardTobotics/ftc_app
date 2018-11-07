package org.firstinspires.ftc.teamcode.VV_2016;

import org.firstinspires.ftc.teamcode.statemachines.State;
import org.firstinspires.ftc.teamcode.statemachines.StateMachine;
import org.firstinspires.ftc.teamcode.statemachines.Transition;

/**
 * Created by Derek Williams of team 3965 on 11/8/2016.
 */

public class LineFollowState extends State {
    protected StateMachine lineFollowStateMachine;
    protected double power;

    LineFollowState(String name, double power, Transition... transitions) {
        super(name, transitions);
        this.power = power;
    }

    @Override
    public void onEntry() {
        super.onEntry();
        /*
        // Adding states to state machine
        lineFollowStateMachine.add(new State[]{
            new WaddleRightState("waddle_right", power),
            new WaddleLeftState("waddle_left", power),
        });

        // Adding transitions to state machine
        lineFollowStateMachine.add(new Transition[]{
            //new LineDetectedTrans("waddle_right", "waddle_left"),
            //new LineUndetectedTrans("waddle_left", "waddle_right"),
        });

        // Setting initial state for line follow state machine
        lineFollowStateMachine.setActiveState("waddle_right");
        */
    }

    @Override
    public void doState() {
        lineFollowStateMachine.step();
    }

    @Override
    public void onExit() {
        lineFollowStateMachine.stop();
    }
}
