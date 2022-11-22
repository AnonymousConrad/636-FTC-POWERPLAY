/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Robot: Auto Drive By Time", group="Robot")

public class RobotAutoDriveByTime_Linear extends LinearOpMode {

    /* Declare OpMode members. */

    private ElapsedTime     runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.

        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        DcMotor motorLinearSlides = hardwareMap.dcMotor.get("motorLinearSlides");

        Servo claw = hardwareMap.servo.get("claw");
        claw.setDirection(Servo.Direction.FORWARD);

        motorBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorFrontRight.setDirection(DcMotor.Direction.FORWARD);
        motorBackRight.setDirection(DcMotor.Direction.FORWARD);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way
        //THIS AUTONOMOUS IS FOR PLACING PRE HELD CONE INTO TOP POLE AND THEN PARKING IN CORNER
        //START THE ROBOT LOOKING STRAIGHT AT THE FRIKIN CODE WITH SCANNY STUFFS

        //CLAW CLOSSSESS ON THE FRIKIN CONE THAT WAS PRE PLACE WOOO
        claw.setPosition(0);
        sleep(500);

        //Step 2:  it does mecanum thingy ba bingy and goes left sideways perfecto oh yeah its called strafing bruh i think

        motorFrontLeft.setPower(-.5);
        motorBackLeft.setPower(.5);
        motorFrontRight.setPower(.5);
        motorBackRight.setPower(-.5);
        sleep(2000);

        //just turning off bruh

        motorFrontLeft.setPower(0);
        motorBackLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackRight.setPower(0);
        sleep(100);

        motorLinearSlides.setPower(1);
        sleep(200);

        //advanced to the poly pole and goes straight to it but not all the way cause it needs space to extend linear slide thingy ka bob
        motorFrontLeft.setPower(.5);
        motorBackLeft.setPower(.5);
        motorFrontRight.setPower(.5);
        motorBackRight.setPower(.5);
        sleep(800);

        //just turning off bruh

        motorFrontLeft.setPower(0);
        motorBackLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackRight.setPower(0);
        sleep(700);

        //LINEAR SLIDE GOES UPPPPP
        motorLinearSlides.setPower(1);
        sleep(1900);

        //just turning off bruh

        motorLinearSlides.setPower(0);
        sleep(100);

        //robot moves SLIGHTLYYYY forward so the cone is aligned with poly pole
        motorFrontLeft.setPower(.5);
        motorBackLeft.setPower(.5);
        motorFrontRight.setPower(.5);
        motorBackRight.setPower(.5);
        sleep(250);

        //just turning off bruh

        motorFrontLeft.setPower(0);
        motorBackLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackRight.setPower(0);
        sleep(100);

        //claw opens up and drops cone (claw already had cone in grasp i think thats allowed)
        claw.setPosition(0.25);
        sleep(500);

        //LINEAR SLIDE GOES DOWNNNNNN
        motorLinearSlides.setPower(-1);
        sleep(1700);

        //RESETTING AND GOING BACKWARDS
        motorFrontLeft.setPower(-.5);
        motorBackLeft.setPower(-.5);
        motorFrontRight.setPower(-.5);
        motorBackRight.setPower(-.5);
        sleep(1000);

        //SHIFTING TO THE RIGHT --- ALL THE WAY TO THE CORNER DUN DUN DUNNNNN
        motorFrontLeft.setPower(1);
        motorBackLeft.setPower(-1);
        motorFrontRight.setPower(-1);
        motorBackRight.setPower(1);
        sleep(3000);


        // Step 4:  Stop
        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackRight.setPower(0);
        motorBackLeft.setPower(0);
        motorLinearSlides.setPower(0);
        // After David's code
        motorFrontLeft.setPower(0.5);
        motorFrontRight.setPower(0.5);
        motorBackRight.setPower(0.5);
        motorBackLeft.setPower(0.5);
        runtime.reset();
        sleep(1000);

        //strafe
        motorFrontLeft.setPower(0.5);
        motorFrontRight.setPower(-0.5);
        motorBackRight.setPower(0.5);
        motorBackLeft.setPower(-0.5);
        runtime.reset();
        sleep(1000);
        //turn
        motorFrontLeft.setPower(-0.5);
        motorFrontRight.setPower(0.5);
        motorBackRight.setPower(0.5);
        motorBackLeft.setPower(-0.5);
        runtime.reset();
        sleep(1000);
        // strafe
        motorFrontLeft.setPower(0.5);
        motorFrontRight.setPower(-0.5);
        motorBackRight.setPower(0.5);
        motorBackLeft.setPower(-0.5);
        runtime.reset();
        sleep(1000);
        //forward
        motorFrontLeft.setPower(0.25);
        motorFrontRight.setPower(0.25);
        motorBackRight.setPower(0.25);
        motorBackLeft.setPower(0.25);
        runtime.reset();
        sleep(1000);

        motorLinearSlides.setPower(.5);
        runtime.reset();
        sleep(1000);
        //closes claw
        claw.setPosition(.3);

        motorFrontLeft.setPower(-0.5);
        motorFrontRight.setPower(-0.5);
        motorBackRight.setPower(-0.5);
        motorBackLeft.setPower(-0.5);
        runtime.reset();
        sleep(1000);

        //turn
        motorFrontLeft.setPower(0.5);
        motorFrontRight.setPower(-0.5);
        motorBackRight.setPower(-0.5);
        motorBackLeft.setPower(0.5);
        runtime.reset();
        sleep(1000);
        //strafe
        motorFrontLeft.setPower(0.5);
        motorFrontRight.setPower(-0.5);
        motorBackRight.setPower(0.5);
        motorBackLeft.setPower(-0.5);
        runtime.reset();
        sleep(1000);

        motorLinearSlides.setPower(1);
        runtime.reset();
        sleep(1000);

        //move forward
        motorFrontLeft.setPower(0.15);
        motorFrontRight.setPower(0.15);
        motorBackRight.setPower(0.15);
        motorBackLeft.setPower(0.15);
        runtime.reset();
        sleep(2000);

        claw.setPosition(0);
        }

    }

