// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kMechanismControllerPort = 1;
    public static final int FLdeviceID = 3;
    public static final int FRdeviceID = 7;
    public static final int BLdeviceID = 4;
    public static final int BRdeviceID = 8;
    public static final int IMdeviceID = 5;
    public static final int IntakeTopID = 1;
    public static final int IntakeBottomID = 2;
    public static final int ShooterOneID = 6;
    public static final int ShooterTwoID = 9;
    public static final boolean FLReverse = false;
    public static final boolean FRReverse = false;
    public static final boolean BLReverse = false;
    public static final boolean BRReverse = false;
    public static final boolean IMReverse = false;
    public static final boolean IntakeOneReverse = false;
    public static final boolean IntakeTwoReverse = true;
    public static final boolean ShooterOneReverse = false;
    public static final boolean ShooterTwoReverse = false;
  }
}
