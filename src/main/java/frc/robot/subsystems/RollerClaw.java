// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;

public class RollerClaw extends SubsystemBase {
    CANSparkMax rollermotor = new CANSparkMax(Constants.ROLLERWHEELID, CANSparkMax.MotorType.kBrushless);

    public RollerClaw() {
        rollermotor.setSmartCurrentLimit(Constants.CURRENTLIMIT);
    }

    public void setSpeed(double speed) {
        rollermotor.set(speed);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}
