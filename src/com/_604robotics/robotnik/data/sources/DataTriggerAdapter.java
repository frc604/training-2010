package com._604robotics.robotnik.data.sources;

import com._604robotics.robotnik.data.DataAccess;
import com._604robotics.robotnik.trigger.TriggerAccess;

public class DataTriggerAdapter implements DataAccess {
    private final TriggerAccess trigger;
    
    public DataTriggerAdapter (TriggerAccess trigger) {
        this.trigger = trigger;
    }
    
    public double get () {
        return this.trigger.get() ? 1D : 0D;
    }
}
