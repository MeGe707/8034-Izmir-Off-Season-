// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    
  
    public PWMVictorSPX left1 = new PWMVictorSPX(1);
    public PWMVictorSPX left2 = new PWMVictorSPX(2);
    public PWMVictorSPX right1 = new PWMVictorSPX(3);
    public PWMVictorSPX right2 = new PWMVictorSPX(4);

    public PWMVictorSPX intake = new PWMVictorSPX(5);
    

    

    


    
    public Timer theTimer = new Timer();
    
    public DifferentialDrive myDrive = new DifferentialDrive(left, right);

    public Joystick myJoystick = new Joystick(0);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
   
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  iü
  ğiü
  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    theTimer.reset();
    theTimer.start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    if (theTimer.get() < 4.0) {
      myDrive.tankDrive(1, 1);
    } else {
      myDrive.stopMotor();
      theTimer.stop();
    }
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    myDrive.tankDrive(myJoystick.getRawAxis(1), myJoystick.getRawAxis(3));

    left.set(myJoystick.getRawAxis(1));   
    right.set(myJoystick.getRawAxis(3));



  }


  @Override
  public void testPeriodic() {}
}
