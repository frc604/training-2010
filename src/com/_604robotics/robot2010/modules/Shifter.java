package com._604robotics.robot2010.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.ActionData;
import com._604robotics.robotnik.module.Module;
import edu.wpi.first.wpilibj.Solenoid;

public class Shifter extends Module {
    private final Solenoid solenoid = new Solenoid(4);
    
    public Shifter () {
        this.set(new ElasticController () {{
            addDefault("Low Gear", new Action() {
                public void begin (ActionData data) {
                    solenoid.set(false);
                }
            });
            
            add("High Gear", new Action() {
                public void begin (ActionData data) {
                    solenoid.set(true);
                }
            });
        }});
    }
}
