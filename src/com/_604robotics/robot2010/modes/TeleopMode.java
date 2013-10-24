package com._604robotics.robot2010.modes;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.Binding;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.prefabs.controller.joystick.JoystickController;
import com._604robotics.robotnik.prefabs.trigger.TriggerOr;
import com._604robotics.robotnik.trigger.TriggerAccess;

public class TeleopMode extends Coordinator {
    private final JoystickController leftDriveStick = new JoystickController(1);
    private final JoystickController rightDriveStick = new JoystickController(1);
    
    public TeleopMode () {
        this.leftDriveStick.axisY.setDeadband(0.2);
        this.rightDriveStick.axisY.setDeadband(0.2);
    }
    
    public void apply (ModuleManager modules) {
        /* Drive Controller */
        {
            /* Drive */
            {
                this.fill(new DataWire(modules.getModule("Drive").getAction("Drive"), "left", leftDriveStick.axisY));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Drive"), "right", rightDriveStick.axisY));
            }
            
            /* Shifting */
            {
                this.bind(new Binding(modules.getModule("Shifter").getAction("High Gear"), new TriggerOr(new TriggerAccess[] {
                    leftDriveStick.buttons.Button1, rightDriveStick.buttons.Button1
                })));
            }
        }
    }
}
