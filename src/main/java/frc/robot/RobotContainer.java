// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.OperateRoller;
import frc.robot.subsystems.RollerClaw;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	private final RollerClaw rollerClaw = new RollerClaw();
    Joystick joystick = new Joystick(Constants.kDriverControllerPort);
    JoystickButton xButton = new JoystickButton(joystick, Constants.CONTROLLERXBUTTON);

	// Replace with CommandPS4Controller or CommandJoystick if needed

	//Joystick joystick = new Joystick(0);
	//private final CommandXboxController m_driverController =
	//    new CommandXboxController(OperatorConstants.kDriverControllerPort);

	/** The container for the robot. Contains subsystems, OI devices, and commands. */
	public RobotContainer() {
		// Configure the trigger bindings
		configureBindings();
	}

	private void configureBindings() {
		xButton.toggleOnTrue(new OperateRoller(rollerClaw, () -> joystick.getRawAxis(Constants.RIGHTSTICKYAXIS)));
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		// An example command will be run in autonomous
		return Commands.none();
	}
}
