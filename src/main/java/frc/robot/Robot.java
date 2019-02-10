/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class Robot extends TimedRobot {

  private Joystick stick = new Joystick(0);
  Button button1 = new JoystickButton(stick, 1);
  private CANSparkMax liftMotor = new CANSparkMax(0, MotorType.kBrushless);
  CANEncoder encoder = new CANEncoder(liftMotor);
  private boolean pressed = false;

  @Override
  public void robotInit() {

  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    double encoderOutput = encoder.getPosition();
    

    if (stick.getRawButton(1)) {
      liftMotor.set(1);
    } else if (stick.getRawButton(2)) {
      liftMotor.set(-1);
    } else {
      liftMotor.set(0.0);
      System.out.println(encoderOutput);
    }
  }
}
