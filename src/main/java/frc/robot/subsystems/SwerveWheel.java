/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.AbsoluteEncoder;
import frc.robot.Constants;


public class SwerveWheel extends SubsystemBase {
    private CANSparkMax m_driveMotor;
    private CANSparkMax m_turnMotor;
    private AbsoluteEncoder m_turnEncoder;

    private SwerveModuleState targetState;

    private Constants m_constants;

    /**
     * Creates a new SwerveWheel.
     */
    public SwerveWheel(CANSparkMax driveMotor, CANSparkMax turnMotor, AbsoluteEncoder encoder, Constants constants) {
        m_driveMotor = driveMotor;
        m_turnMotor = turnMotor;
        m_turnEncoder = encoder;
        m_constants = constants;
    }

    public void SetDesiredState (SwerveModuleState state) {
        m_driveMotor.set(state.speedMetersPerSecond / m_constants.maxMetersPerSecond);
        targetState = state;
    }
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
