// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.RollerClaw;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class OperateRoller extends CommandBase {
    private final RollerClaw subsystem;
    private final DoubleSupplier axi;

    public OperateRoller(RollerClaw subsystem, DoubleSupplier axi) {
        System.out.println("hello");
        this.subsystem = subsystem;
        this.axi = axi;
        addRequirements(subsystem);
    }

    private double getMotorSpeed() {
        if (Math.abs(axi.getAsDouble()) > Constants.DEADZONE) {
            // power function
            return Constants.SPEEDMODIFIER * Math.pow(axi.getAsDouble(), 3);
        }
        return 0.0;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        subsystem.setSpeed(getMotorSpeed());
        System.out.println(getMotorSpeed());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
