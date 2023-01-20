package com.seroja.function;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class FunctionCalculatorTest {
    FunctionCalculator fc;
    @BeforeEach
    void setUp(){
     fc = new FunctionCalculator();
    }

    @ParameterizedTest
    @CsvSource({"1.6, -0.448563", "0.5, 1", "0.9, 0.042671"})
    void testSolve(double x, double expectedY){
        assertThat(fc.solve(x)).isCloseTo(expectedY, Percentage.withPercentage(0.001));
    }

}