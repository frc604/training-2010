package com._604robotics.robot2010.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.ActionData;
import com._604robotics.robotnik.module.Module;
import edu.wpi.first.wpilibj.Solenoid;

public class Kicker extends Module {
    private final Solenoid releaseSolenoid = new Solenoid(3);
    
    public Kicker () {
        this.set(new ElasticController () {{
            addDefault("Lock", new Action() {
                public void begin (ActionData data) {
                    releaseSolenoid.set(false);
                }
            });
            
            add("Kick", new Action() {
                public void begin (ActionData data) {
                    releaseSolenoid.set(true);
                }
            });
        }});
    }
}
