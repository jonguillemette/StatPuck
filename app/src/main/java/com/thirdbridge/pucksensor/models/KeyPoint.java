package com.thirdbridge.pucksensor.models;

import org.json.JSONObject;

/**
 * Created by Jayson Dalpé on 2016-04-20.
 * Class KeyPoint: A KeyPoint is a moment of interest inside an exercise. Each KeyPoint has calibration data to let you help to mimic the full exercise.
 * For instance: A KeyPoint can be the Target acceleration at the next step.
 */
public class KeyPoint {

    enum Status {
        NOT_INIT,
        INIT,
        COMPUTED,
    };

    public enum Data {
        ACCELERATION_INIT_X,
        ACCELERATION_INIT_Y,
        ACCELERATION_END_X,
        ACCELERATION_END_Y,
        DELTA_TIME,
        DELTA_FLYING_TIME,
        ACCELERATION_MEAN,
        ACCELERATION_MAX,
        DIRECTION_RAW_START,
        DIRECTION_RAW_END,
        ROTATION_DELTA,
        ACCEL_Z,
        DIRECTION_START,
        DIRECTION_END,
        QUALITY_DIRECTION_MAGNITUDE,
        QUALITY_DIRECTION_ORIENTATION
    }

    public static String getUnits(Data data) {
        switch (data) {
            case ACCELERATION_INIT_X:
                return "g";
            case ACCELERATION_INIT_Y:
                return "g";
            case ACCELERATION_END_X:
                return "g";
            case ACCELERATION_END_Y:
                return "g";
            case DELTA_TIME:
                return "ms";
            case DELTA_FLYING_TIME:
                return "ms";
            case ACCELERATION_MEAN:
                return "g";
            case ACCELERATION_MAX:
                return "g";
            case DIRECTION_RAW_START:
                return "degree";
            case DIRECTION_RAW_END:
                return "degree";
            case ROTATION_DELTA:
                return "degree/s";
            case ACCEL_Z:
                return "g";
            case DIRECTION_START:
                return "degree";
            case DIRECTION_END:
                return "degree";
            case QUALITY_DIRECTION_MAGNITUDE:
                return "";
            case QUALITY_DIRECTION_ORIENTATION:
                return "degree";
        }
        return "";
    }


    // Primary data
    public double accelerationInitX;
    public double accelerationInitY;
    public double accelerationEndX;
    public double accelerationEndY;
    public double deltaTime;
    public double deltaFlyingTime;
    public double accelerationMean;
    public double accelerationMax;
    public double directionRawStart;
    public double directionRawEnd;
    public double rotationDelta;
    public double accelZ;

    // Computed data
    public double directionStart;
    public double directionEnd;
    public double qualityDirectionMagnitude;
    public double qualityDirectionOrientation;

    // Which data is used
    public boolean gotAccelerationInitX = false;
    public boolean gotAccelerationInitY = false;
    public boolean gotAccelerationEndX = false;
    public boolean gotAccelerationEndY = false;
    public boolean gotDeltaTime = false;
    public boolean gotDeltaFlyingTime = false;
    public boolean gotAccelerationMean = false;
    public boolean gotAccelerationMax = false;
    public boolean gotDirectionRawStart = false;
    public boolean gotDirectionRawEnd = false;
    public boolean gotRotationDelta = false;
    public boolean gotAccelZ = false;
    public boolean gotDirectionStart = false;
    public boolean gotDirectionEnd = false;
    public boolean gotQualityDirectionMagnitude = false;
    public boolean gotQualityDirectionOrientation = false;

    private Status mStatus;

    public KeyPoint() {
        mStatus = Status.NOT_INIT;
    }

    public KeyPoint(byte[][] rawValues) {
        mStatus = Status.INIT;
        //TODO Create basic data.
    }

    public KeyPoint(JSONObject jsonPoint) {

        try {
            accelerationInitX = jsonPoint.getDouble(Keys.ACCELERATION_INIT_X);
            gotAccelerationInitX = true;
        } catch(Exception e) {}

        try {
            accelerationInitY = jsonPoint.getDouble(Keys.ACCELERATION_INIT_Y);
            gotAccelerationInitY = true;
        } catch(Exception e) {}

        try {
            accelerationEndX = jsonPoint.getDouble(Keys.ACCELERATION_END_X);
            gotAccelerationEndX = true;
        } catch(Exception e) {}

        try {
            accelerationEndY = jsonPoint.getDouble(Keys.ACCELERATION_END_Y);
            gotAccelerationEndY = true;
        } catch(Exception e) {}

        try {
            deltaTime = jsonPoint.getDouble(Keys.DELTA_TIME);
            gotDeltaTime = true;
        } catch(Exception e) {}

        try {
            deltaFlyingTime = jsonPoint.getDouble(Keys.DELTA_FLYING_TIME);
            gotDeltaFlyingTime = true;
        } catch(Exception e) {}

        try {
            accelerationMean = jsonPoint.getDouble(Keys.ACCELERATION_MEAN);
            gotAccelerationMean = true;
        } catch(Exception e) {}

        try {
            accelerationMax = jsonPoint.getDouble(Keys.ACCELERATION_MAX);
            gotAccelerationMax = true;
        } catch(Exception e) {}

        try {
            directionRawStart = jsonPoint.getDouble(Keys.DIRECTION_RAW_START);
            gotDirectionRawStart = true;
        } catch(Exception e) {}

        try {
            directionRawEnd = jsonPoint.getDouble(Keys.DIRECTION_RAW_END);
            gotDirectionRawEnd = true;
        } catch(Exception e) {}

        try {
            rotationDelta = jsonPoint.getDouble(Keys.ROTATION_DELTA);
            gotRotationDelta = true;
        } catch(Exception e) {}

        try {
            accelZ = jsonPoint.getDouble(Keys.ACCEL_Z);
            gotAccelZ = true;
        } catch(Exception e) {}

        try {
            directionStart = jsonPoint.getDouble(Keys.DIRECTION_START);
            gotDirectionStart = true;
        } catch(Exception e) {}

        try {
            directionEnd = jsonPoint.getDouble(Keys.DIRECTION_END);
            gotDirectionEnd = true;
        } catch(Exception e) {}

        try {
            qualityDirectionMagnitude = jsonPoint.getDouble(Keys.QUALITY_DIRECTION_MAGNITUDE);
            gotQualityDirectionMagnitude = true;
        } catch(Exception e) {}

        try {
            qualityDirectionOrientation = jsonPoint.getDouble(Keys.QUALITY_DIRECTION_ORIENTATION);
            gotQualityDirectionOrientation = true;
        } catch(Exception e) {}

        mStatus = Status.COMPUTED;
    }

    public KeyPoint(Object[] datas, Data[] types) {
        mStatus = Status.INIT;
        for (int i=0; i<datas.length; i++) {
            switch(types[i]) {
                case ACCELERATION_INIT_X:
                    accelerationInitX = (double) datas[i];
                    gotAccelerationInitX = true;
                    break;
                case ACCELERATION_INIT_Y:
                    accelerationInitY = (double) datas[i];
                    gotAccelerationInitY = true;
                    break;
                case ACCELERATION_END_X:
                    accelerationEndX = (double) datas[i];
                    gotAccelerationEndX = true;
                    break;
                case ACCELERATION_END_Y:
                    accelerationEndY = (double) datas[i];
                    gotAccelerationEndY = true;
                    break;
                case DELTA_TIME:
                    deltaTime = (double) datas[i];
                    gotDeltaTime = true;
                    break;
                case DELTA_FLYING_TIME:
                    deltaFlyingTime = (double) datas[i];
                    gotDeltaFlyingTime = true;
                    break;
                case ACCELERATION_MEAN:
                    accelerationMean = (double) datas[i];
                    gotAccelerationMean = true;
                    break;
                case ACCELERATION_MAX:
                    accelerationMax = (double) datas[i];
                    gotAccelerationMax = true;
                    break;
                case DIRECTION_RAW_START:
                    directionRawStart = (double) datas[i];
                    gotDirectionRawStart = true;
                    break;
                case DIRECTION_RAW_END:
                    directionRawEnd = (double) datas[i];
                    gotDirectionRawEnd = true;
                    break;
                case ROTATION_DELTA:
                    rotationDelta = (double) datas[i];
                    gotRotationDelta = true;
                    break;
                case ACCEL_Z:
                    accelZ = (double) datas[i];
                    gotAccelZ = true;
                    break;
                case DIRECTION_START:
                    directionStart = (double) datas[i];
                    gotDirectionStart = true;
                    break;
                case DIRECTION_END:
                    directionEnd = (double) datas[i];
                    gotDirectionEnd = true;
                    break;
                case QUALITY_DIRECTION_MAGNITUDE:
                    qualityDirectionMagnitude = (double) datas[i];
                    gotQualityDirectionMagnitude = true;
                    break;
                case QUALITY_DIRECTION_ORIENTATION:
                    qualityDirectionOrientation = (double) datas[i];
                    gotQualityDirectionOrientation = true;
                    break;
            }
        }
    }

    public void compute() {
        if (mStatus != Status.COMPUTED) {
            mStatus = Status.COMPUTED;
            // Get Direction Start
            double angleAccel = Math.atan2(accelerationInitY, accelerationInitX);
            directionStart = (Math.toDegrees(angleAccel) + directionRawStart) % 360;
            gotDirectionStart = true;

            angleAccel = Math.atan2(accelerationEndY, accelerationEndX);
            directionEnd = (Math.toDegrees(angleAccel) + directionRawEnd) % 360;
            gotDirectionEnd = true;

            // Retrieve X and Y from new direction.
            // Start
            double magnitude = Math.sqrt(Math.pow(accelerationInitX, 2) + Math.pow(accelerationInitY, 2));
            double dir11 = magnitude * Math.cos(Math.toRadians(directionStart));
            double dir21 = magnitude * Math.sin(Math.toRadians(directionStart));
            // End
            magnitude = Math.sqrt(Math.pow(accelerationEndX, 2) + Math.pow(accelerationEndY, 2));
            double dir12 = magnitude * Math.cos(Math.toRadians(directionEnd));
            double dir22 = magnitude * Math.sin(Math.toRadians(directionEnd));

            double x1 = 0;
            double x2 = deltaTime / 1000;

            // derivation 1
            double y1 = dir11;
            double y2 = dir12;

            double slopeX = (y2 - y1) / (x2 - x1);

            y1 = dir21;
            y2 = dir22;

            double slopeY = (y2 - y1) / (x2 - x1);

            qualityDirectionMagnitude = Math.sqrt(Math.pow(slopeX, 2) + Math.pow(slopeY, 2));
            gotQualityDirectionMagnitude = true;
            qualityDirectionOrientation = Math.toDegrees(Math.atan2(slopeY, slopeX));
            gotQualityDirectionOrientation = true;
            gotQualityDirectionOrientation = true;
        }
    }

    public String packageFormCSV() {
        //Package every stat into a CSV string format. Create a one line of everything. When multiple KeyPoints, be sure that they are the same type.
        String retValue = "";
        retValue += gotAccelerationInitX ? accelerationInitX + "," : "";
        retValue += gotAccelerationInitY ? accelerationInitY + "," : "";
        retValue += gotAccelerationEndX ? accelerationEndX + "," : "";
        retValue += gotAccelerationEndY ? accelerationEndY + "," : "";
        retValue += gotDeltaTime ? deltaTime + "," : "";
        retValue += gotDeltaFlyingTime ? deltaFlyingTime + "," : "";
        retValue += gotAccelerationMean ? accelerationMean + "," : "";
        retValue += gotAccelerationMax ? accelerationMax + "," : "";
        retValue += gotDirectionRawStart ? directionRawStart + "," : "";
        retValue += gotDirectionRawEnd ? directionRawEnd + "," : "";
        retValue += gotAccelZ ? accelZ + "," : "";
        retValue += gotRotationDelta ? rotationDelta + "," : "";
        retValue += gotDirectionStart ? directionStart + "," : "";
        retValue += gotDirectionEnd ? directionEnd + "," : "";
        retValue += gotQualityDirectionMagnitude ? qualityDirectionMagnitude + "," : "";
        retValue += gotQualityDirectionOrientation ? qualityDirectionOrientation + "," : "";

        return retValue;
    }

    public String packageTitleFormCSV() {
        //Package every stat into a CSV string format. Create a one line of everything. When multiple KeyPoints, be sure that they are the same type.
        String retValue = "";
        retValue += gotAccelerationInitX ? Keys.ACCELERATION_INIT_X + "(" + getUnits(Data.ACCELERATION_INIT_X) + ")" + "," : "";
        retValue += gotAccelerationInitY ? Keys.ACCELERATION_INIT_Y + "(" + getUnits(Data.ACCELERATION_INIT_Y) + ")" + "," : "";
        retValue += gotAccelerationEndX ? Keys.ACCELERATION_END_X + "(" + getUnits(Data.ACCELERATION_END_X) + ")"  + "," : "";
        retValue += gotAccelerationEndY ? Keys.ACCELERATION_END_Y + "(" + getUnits(Data.ACCELERATION_END_Y) + ")"  + "," : "";
        retValue += gotDeltaTime ? Keys.DELTA_TIME + "(" + getUnits(Data.DELTA_TIME) + ")"  + "," : "";
        retValue += gotDeltaFlyingTime ? Keys.DELTA_FLYING_TIME + "(" + getUnits(Data.DELTA_FLYING_TIME) + ")"  + "," : "";
        retValue += gotAccelerationMean ? Keys.ACCELERATION_MEAN + "(" + getUnits(Data.ACCELERATION_MEAN) + ")"  + "," : "";
        retValue += gotAccelerationMax ? Keys.ACCELERATION_MAX + "(" + getUnits(Data.ACCELERATION_MAX) + ")"  + "," : "";
        retValue += gotDirectionRawStart ? Keys.DIRECTION_RAW_START + "(" + getUnits(Data.DIRECTION_RAW_START) + ")"  + "," : "";
        retValue += gotDirectionRawEnd ? Keys.DIRECTION_RAW_END + "(" + getUnits(Data.DIRECTION_RAW_END) + ")"  + "," : "";
        retValue += gotAccelZ ? Keys.ACCEL_Z + "(" + getUnits(Data.ACCEL_Z) + ")"  + "," : "";
        retValue += gotRotationDelta ? Keys.ROTATION_DELTA + "(" + getUnits(Data.ROTATION_DELTA) + ")"  + "," : "";
        retValue += gotDirectionStart ? Keys.DIRECTION_START + "(" + getUnits(Data.DIRECTION_START) + ")"  + "," : "";
        retValue += gotDirectionEnd ? Keys.DIRECTION_END + "(" + getUnits(Data.DIRECTION_END) + ")"  + "," : "";
        retValue += gotQualityDirectionMagnitude ? Keys.QUALITY_DIRECTION_MAGNITUDE + "(" + getUnits(Data.QUALITY_DIRECTION_MAGNITUDE) + ")"  + "," : "";
        retValue += gotQualityDirectionOrientation ? Keys.QUALITY_DIRECTION_ORIENTATION + "(" + getUnits(Data.QUALITY_DIRECTION_ORIENTATION) + ")"  + "," : "";

        return retValue;
    }

    public Status getStatus() {
        return mStatus;
    }


    public void setStatus(Status mStatus) {
        this.mStatus = mStatus;
    }

    private class Keys {
        public final static String ACCELERATION_INIT_X = "acceleration_init_x";
        public final static String ACCELERATION_INIT_Y = "acceleration_init_y";
        public final static String ACCELERATION_END_X = "acceleration_end_x";
        public final static String ACCELERATION_END_Y = "acceleration_end_y";
        public final static String DELTA_TIME = "delta_time";
        public final static String DELTA_FLYING_TIME = "delta_flyig_time";
        public final static String ACCELERATION_MEAN = "acceleration_mean";
        public final static String ACCELERATION_MAX = "acceleration_max";
        public final static String DIRECTION_RAW_START = "direction_raw_start";
        public final static String DIRECTION_RAW_END = "direction_raw_end";
        public final static String ROTATION_DELTA = "rotation_delta";
        public final static String ACCEL_Z = "accel_z";
        public final static String DIRECTION_START = "direction_start";
        public final static String DIRECTION_END = "direction_end";
        public final static String QUALITY_DIRECTION_MAGNITUDE = "quality_direction_magnitude";
        public final static String QUALITY_DIRECTION_ORIENTATION = "quality_direction_orientation";
    }

}
