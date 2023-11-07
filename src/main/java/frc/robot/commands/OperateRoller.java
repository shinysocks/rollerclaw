// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.RollerClaw;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class OperateRoller extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RollerClaw m_subsystem;
  private Joystick m_joystick;

  public OperateRoller(RollerClaw subsystem, Joystick joystick) {
    m_subsystem = subsystem;
    m_joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  private double getMotorSpeed() {
    double axis = m_joystick.getRawAxis(Constants.RIGHTSTICKYAXIS);
    if (Math.abs(axis) > Constants.DEADZONE) {
      // power function
      return Constants.SPEEDMODIFIER * Math.pow(axis, 3);
    }
    return 0.0;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.setSpeed(getMotorSpeed());
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
