package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.MyPersonRepeatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonRepeatedtests implements MyPersonRepeatedTest {

    // This test will run 10 time. The variables in the {} can be found in public @interface RepeatedTest {
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
        // todo -impl
        assertThat("test").isEqualTo("TEST".toLowerCase());
    }

    // JUnit Test Dependency Injection - not really DI but you can have
    // parameters being passed into a test method. Currently three parameters
    // are inbuilt but the API is extensible if more than the three defined
    // paramteres are required
    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    // Assignment
    @RepeatedTest(value = 15, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Assignment Repeated Test")
    void assignmentTest() {
        //
    }
}
