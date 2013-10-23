package com._604robotics.robot2010;

import com._604robotics.robot2010.modes.TeleopMode;
import com._604robotics.robotnik.Robot;
import com._604robotics.robotnik.coordinator.ModeMap;

public class Robot2010 extends Robot {
    public Robot2010 () {
        this.set(new ModeMap() {{
            setTeleopMode(new TeleopMode());
        }});
    }
}
