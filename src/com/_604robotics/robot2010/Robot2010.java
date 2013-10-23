package com._604robotics.robot2010;

import com._604robotics.robot2010.modes.TeleopMode;
import com._604robotics.robot2010.modules.Drive;
import com._604robotics.robot2010.modules.Shifter;
import com._604robotics.robotnik.Robot;
import com._604robotics.robotnik.coordinator.ModeMap;
import com._604robotics.robotnik.module.ModuleMap;

public class Robot2010 extends Robot {
    public Robot2010 () {
        this.set(new ModuleMap() {{
            add("Drivee", new Drive());
            add("Shifter", new Shifter());
        }});
        
        this.set(new ModeMap() {{
            setTeleopMode(new TeleopMode());
        }});
    }
}
