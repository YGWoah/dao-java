package com.dbconnection.utils;

import java.util.UUID;

public class RandomIntGenerator {

    public static int generateRandomInt() {
        return UUID.randomUUID().hashCode();
    }
}