package com._604robotics.robot2010.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.ActionData;
import com._604robotics.robotnik.module.Module;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Piston extends Module {
    private final DoubleSolenoid reloadSolenoid = new DoubleSolenoid(1, 2);
    
    public Piston () {
        this.set(new ElasticController () {{
            addDefault("Retract", new Action() {
                public void begin (ActionData data) {
                    reloadSolenoid.set(Value.kReverse);
                }
            });
            
            add("Extend", new Action() {
                public void begin (ActionData data) {
                    reloadSolenoid.set(Value.kForward);
                }
            });
        }});
    }
}
