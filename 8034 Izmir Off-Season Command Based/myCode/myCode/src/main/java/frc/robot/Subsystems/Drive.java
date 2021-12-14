// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/** Add your docs here. */
public class Drive {
    private static Drive mInstance = new Drive();

    public static Drive getInstance(){
        return mInstance;
    }
    // Master VictorSPX
    public WPI_VictorSPX driveLMaster;
    public WPI_VictorSPX driveRMaster;

    // Follower VictorSPX
    public WPI_VictorSPX driveLTwo;
    public WPI_VictorSPX driveRTwo;
    public SpeedControllerGroup leftMotor;
    public SpeedControllerGroup rightMotor;
    public DifferentialDrive differentialDrive;

    
    private Drive(){
        // EVERYTHING IS IN METERS
        driveLMaster = new WPI_VictorSPX(0);
        driveRMaster = new WPI_VictorSPX(2);

        driveLTwo = new WPI_VictorSPX(1);
        driveRTwo = new WPI_VictorSPX(3); 

        leftMotor = new SpeedControllerGroup(driveLMaster, driveLTwo);
        rightMotor = new SpeedControllerGroup(driveRMaster, driveRTwo);

        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
    }

    /**
     * Robot Drive Using Arcade Drive
     * @param speed
     * @param rotation_speed
     */
    public void robotDrive(double speed, double rotation_speed){
        robotDrive(speed, rotation_speed, 1);
    }

    /**
     * Robot Drive Using Arcade Drive
     * @param speed
     * @param rotation_speed
     * @param sensitivity
     */
    public void robotDrive(double speed, double rotation_speed, double sensivity){
        differentialDrive.arcadeDrive(speed, rotation_speed*sensivity);
    }
    
}