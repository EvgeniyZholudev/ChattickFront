package com.example.chattickfront;

public class DataTypesTransfer {

    public static Boolean longToBoolean(Long input) {
        return input != 0;
    }

    public static Long booleanToLong(Boolean input) {
        return input ? 1L : 0;
    }
}
