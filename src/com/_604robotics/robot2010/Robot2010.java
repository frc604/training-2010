package com._604robotics.robot2010;

import com._604robotics.robot2010.modes.TeleopMode;
import com._604robotics.robot2010.modules.Drive;
import com._604robotics.robot2010.modules.Kicker;
import com._604robotics.robot2010.modules.Regulator;
import com._604robotics.robot2010.modules.Shifter;
import com._604robotics.robotnik.Robot;
import com._604robotics.robotnik.coordinator.ModeMap;
import com._604robotics.robotnik.module.ModuleMap;

public class Robot2010 extends Robot {
    public Robot2010 () {
        this.set(new ModuleMap() {{
            add("Drive", new Drive());
            add("Shifter", new Shifter());
            add("Regulator", new Regulator());
            add("Kicker", new Kicker());
            add("Piston", new Piston());
        }});
        
        this.set(new ModeMap() {{
            setTeleopMode(new TeleopMode());
        }});
    }
}
