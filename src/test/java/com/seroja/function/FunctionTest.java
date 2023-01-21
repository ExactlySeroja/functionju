package com.seroja.function;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


class FunctionTest {
    Function fc;
    @BeforeEach
    void setUp(){
     fc = new Function();
    }

    @ParameterizedTest
    @CsvSource({"1.6, -0.448563", "0.5, 1", "0.9, 0.042671"})
    void testSolve(double x, double expectedY){
        assertThat(fc.solve(x)).isCloseTo(expectedY, Percentage.withPercentage(0.001));
    }

    @ParameterizedTest
    @CsvSource({"175, 0.7", "350, 1.4", "750, 3.0"})
    void testFillArrayX(int index, double expected){
        ArrayList<Double> list = fc.fillArrayX();
        assertThat(list.get(index)).isCloseTo(expected, Percentage.withPercentage(0.001));
    }

    @ParameterizedTest
    @CsvSource({"175, 1", "350, -0.329743","750, 0.214243"})
    void testFillArrayY(int index, double expected){
        ArrayList<Double> list = fc.fillArrayY();
        assertThat(list.get(index)).isCloseTo(expected, Percentage.withPercentage(0.01));
    }

    @Test
    void testFindMax(){
        ArrayList<Double> list = fc.fillArrayY();
        double actual = fc.findMaxY(list);
        double expected = 1.0;
        assertThat(actual).isCloseTo(expected, Percentage.withPercentage(0.001));

    }

    @Test
    void testFindMin(){
        ArrayList<Double> list = fc.fillArrayY();
        double actual = fc.findMinY(list);
        double expected = -0.47026166;
        assertThat(actual).isCloseTo(expected, Percentage.withPercentage(0.001));
    }

    @Test
    void testFindSum(){
        double expected = 3.0;
        ArrayList<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(2.0);
        assertThat(fc.findSum(list)).isCloseTo(expected, Percentage.withPercentage(0.001));
    }

    @Test
    void testFindAverage(){
        double expected = 2.0;
        ArrayList<Double> list = new ArrayList<>();
        list.add(2.0);
        list.add(3.0);
        list.add(1.0);
        assertThat(fc.findAverage(list)).isCloseTo(expected, Percentage.withPercentage(0.001));
    }

}