package xyz.devyu.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RepeatedTest {

    @org.junit.jupiter.api.RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("반복 테스트")
    void repeated_test1(RepetitionInfo repetitionInfo) {

        System.out.println(repetitionInfo.getTotalRepetitions());
        System.out.println(repetitionInfo.getCurrentRepetition());

    }

    @ParameterizedTest
    @ValueSource(strings = {"반복", "테스트", "진행중"})
    @DisplayName("고정 파라미터 반복 테스트")
    void repeated_test2(String message) {
        System.out.println(message);
    }

}
