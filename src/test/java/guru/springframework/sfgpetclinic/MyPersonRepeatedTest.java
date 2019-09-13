package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@Tag("repeated-model")
public interface MyPersonRepeatedTest {

    @BeforeEach
    // RepetitionInfo is only registered for classes that are repeating. Putting it on
    // non-repeating classes will cause those classes to fail tests
    default void beforeEachMethod(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName()
                + ": " + repetitionInfo.getCurrentRepetition()
                + " - " + repetitionInfo.getTotalRepetitions());
    }
}
