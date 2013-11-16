package com._604robotics.robot2010.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.ActionData;
import com._604robotics.robotnik.module.Module;
import com._604robotics.robotnik.trigger.Trigger;
import com._604robotics.robotnik.trigger.TriggerMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class Kicker extends Module {
    private final Solenoid releaseSolenoid = new Solenoid(3);
    private final Timer timer = new Timer();
    
    public Kicker () {
        this.set(new TriggerMap () {{
            add("Travelling", new Trigger () {
                public boolean run () {
                    return timer.get() < 2;
                }
            });
        }});
        
        this.set(new ElasticController () {{
            addDefault("Lock", new Action() {
                public void begin (ActionData data) {
                    releaseSolenoid.set(false);
                    
                    timer.reset();
                    timer.start();
                }
                
                public void end (ActionData data) {
                    timer.stop();
                }
            });
            
            add("Kick", new Action() {
                public void begin (ActionData data) {
                    releaseSolenoid.set(true);
                    
                    timer.reset();
                    timer.start();
                }
                
                public void end (ActionData data) {
                    timer.stop();
                }
            });
        }});
    }
}
