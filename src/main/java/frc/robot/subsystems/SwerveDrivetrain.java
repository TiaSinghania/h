/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.AbsoluteEncoder;

public class SwerveDrivetrain extends SubsystemBase {
    private SwerveWheel m_frontLeft;
    private SwerveWheel m_frontRight;
    private SwerveWheel m_backLeft;
    private SwerveWheel m_backRight;

    private CANSparkMax m_frontLeftDriveMotor;
    private CANSparkMax m_frontRightDriveMotor;
    private CANSparkMax m_backLeftDriveMotor;
    private CANSparkMax m_backRightDriveMotor;

    private CANSparkMax m_frontLeftTurnMotor;
    private CANSparkMax m_frontRightTurnMotor;
    private CANSparkMax m_backLeftTurnMotor;
    private CANSparkMax m_backRightTurnMotor;

    private AbsoluteEncoder m_frontLeftTurnEncoder;
    private AbsoluteEncoder m_frontRightTurnEncoder;
    private AbsoluteEncoder m_backLeftTurnEncoder;
    private AbsoluteEncoder m_backRightTurnEncoder;

    private double m_xSpeed;
    private double m_ySpeed;
    private double m_rotSpeed;

    private Constants m_constants = new Constants();

    /**
     * Creates a new ExampleSubsystem.
     */
    public SwerveDrivetrain() {
        m_frontLeftDriveMotor = new CANSparkMax(12, MotorType.kBrushless);         
        m_frontRightDriveMotor = new CANSparkMax(1, MotorType.kBrushless);         
        m_backLeftDriveMotor = new CANSparkMax(2, MotorType.kBrushless);         
        m_backRightDriveMotor = new CANSparkMax(3, MotorType.kBrushless);  
        
        m_frontLeftTurnMotor = new CANSparkMax(4, MotorType.kBrushless);         
        m_frontRightTurnMotor = new CANSparkMax(5, MotorType.kBrushless);         
        m_backLeftTurnMotor = new CANSparkMax(6, MotorType.kBrushless);         
        m_backRightTurnMotor = new CANSparkMax(7, MotorType.kBrushless);  

        m_frontLeftDriveMotor.setInverted(true);
        m_backLeftDriveMotor.setInverted(true);
        m_frontRightDriveMotor.setInverted(false);
        m_backRightDriveMotor.setInverted(false);

        m_frontLeftTurnEncoder = new AbsoluteEncoder(8, true, m_constants.frontLeftSwerveOffset);
        m_frontRightTurnEncoder = new AbsoluteEncoder(9, true, m_constants.frontRightSwerveOffset);
        m_backLeftTurnEncoder = new AbsoluteEncoder(10, true, m_constants.backLeftSwerveOffset);
        m_backRightTurnEncoder = new AbsoluteEncoder(11, true, m_constants.backRightSwerveOffset);

        m_frontLeft = new SwerveWheel(m_frontLeftDriveMotor, m_frontLeftTurnMotor, m_frontLeftTurnEncoder);
        m_frontRight = new SwerveWheel(m_frontRightDriveMotor, m_frontRightTurnMotor, m_frontRightTurnEncoder);
        m_backLeft = new SwerveWheel(m_backLeftDriveMotor, m_backLeftTurnMotor, m_backLeftTurnEncoder);
        m_backRight = new SwerveWheel(m_backRightDriveMotor, m_backRightTurnMotor, m_backRightTurnEncoder);
    }

    public void move (double xSpeed, double ySpeed, double rotSpeed) {
        m_xSpeed = xSpeed;
        m_ySpeed = ySpeed;
        m_rotSpeed = rotSpeed;
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
