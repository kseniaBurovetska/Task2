package tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import task2.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

    private static Controller controller;
    private static Model model;

    @BeforeClass
    public static void initTest() {
        View view = new View();
        model = new Model();
        controller = new Controller(view, model);

        // model.setTargetValue(50);
    }

    @Test
    public void validateInRangeDefaultTest() {
        int input = 10;

        model.generateValue();
        Assert.assertEquals(input, controller.validateValueWithRange(new Scanner(String.valueOf(input))));
    }


    @Test
    public void validateRangeAdjustedTest() {
        int input = 20;

        model.generateValue();
        Assert.assertEquals(input, controller.validateValueWithRange(new Scanner(String.valueOf(input))));

    }

    @Test
    public void checkForTargetMoreTest() {
        Assert.assertFalse(model.checkForTarget(20));
    }

    @Test
    public void checkForTargetLessTest() {
        Assert.assertFalse(model.checkForTarget(80));
    }

    @Test
    public void checkForTargetTest() {
        Assert.assertTrue(model.checkForTarget(50));
    }

    @Test
    @Ignore
    public void checkRandomTest() {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 40000; i++) {
            nums.add(model.generateValue());
        }

        Assert.assertTrue(nums.contains(1));
        Assert.assertTrue(nums.contains(99));
        Assert.assertFalse(nums.contains(100));
        Assert.assertFalse(nums.contains(0));

    }

}
