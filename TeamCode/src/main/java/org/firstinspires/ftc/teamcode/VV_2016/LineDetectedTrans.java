package org.firstinspires.ftc.teamcode.VV_2016;

/**
 * Created by Derek Williams of team 3965 on 11/8/2016.
 */

public class LineDetectedTrans extends SensorTrans {
    public LineDetectedTrans (String destination, SensorModule sensors) {
        super(destination, sensors);
    }

    @Override
    public boolean test() {
        return sensors.isLineDetected();
    }
}
