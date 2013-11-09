package com._604robotics.robot2010.modules;

import com._604robotics.robotnik.module.Module;
import edu.wpi.first.wpilibj.Compressor;

public class Regulator extends Module {
    private final Compressor compressor = new Compressor(1, 1);
}
