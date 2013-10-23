package com._604robotics.robot2010.modes;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.Binding;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.prefabs.controller.xbox.XboxController;

public class TeleopMode extends Coordinator {
    private final XboxController driveController = new XboxController(1);
    
    public TeleopMode () {
        this.driveController.leftStick.Y.setDeadband(0.2);
        this.driveController.rightStick.Y.setDeadband(0.2);
    }
    
    public void apply (ModuleManager modules) {
        /* Drive Controller */
        {
            /* Drive */
            {
                this.fill(new DataWire(modules.getModule("Drive").getAction("Drive"), "left", driveController.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Drive"), "right", driveController.rightStick.Y));
            }
            
            /* Shifting */
            {
                this.bind(new Binding(modules.getModule("Shifter").getAction("High Gear"), driveController.buttons.RT));
            }
        }
    }
}
