package com.treasureisland.utilities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 12:21 PM
 */
public class MyMethodsTest {

    @Test
    public void getRandomNumberPositive() {
        MyMethods.getRandomNumber(6);

    }

    @Test
    public void getRandomNumberNegative() {
        MyMethods.getRandomNumber(-6);

    }
}
