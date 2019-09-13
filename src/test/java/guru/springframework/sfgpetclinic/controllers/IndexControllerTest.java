package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.exceptions.ValueNotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controllers")
class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    // Display name allows the display name to be displayed in the test run instead of the method name
    // This allows more descriptive name to be written in test reports.
    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");
        assertEquals("index", controller.index(), () -> "Another Expensive Message " +
                "Make me only if you have to");

        // an AssertJ library assertion. Mix and match can be done but generally JUnit will be adequate to handle your assertions
        assertThat(controller.index()).isEqualTo("index");
    }

    // using a Lambda expression for your message. You can use that to run a complex function when
    // there is a failure
    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(controller.oupsHandler()), ()-> "This is some expensive " +
                "Message to build");
    }

    // testing expected exceptions
    @Test
    @DisplayName("Test if ValueNotFoundException is thrown")
    void oupsHandlerException() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandlerException();
        });
    }

    // Runs in the same thread and you can actually see the delay in the program execution
    @Disabled // disabled because the tests are failing
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), ()-> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    // Runs in a different thread and JUnit can monitor the different thread and will see that the thread
    // exceed the 100 milliseconds.
    @Disabled // disabled because the tests are failing
    @Test
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here XXXXXXXX"); // we never get to this statement because JUnit terminates
            // the thread when 100 milliseconds are exceeded.
        });
    }

    // If this test fails, it results in the Test method being disabled at runtime instead of registering a test fail.
    @DisplayName("Test if environment variable SAMSON_RUNTIME is set to 'Samson'")
    @Test
    void testAssumptionTrue() {
        assumeTrue("Samson".equalsIgnoreCase(System.getenv("SAMSON_RUNTIME")));
    }


    // If this test fails, it results in the Test method being disabled at runtime instead of registering a test fail.
    @DisplayName("Test if environment variables USERNAME and PROCESSOR_ARCHITECTURE are set to the variables Samson and amd64 respectively")
    @Test
    void testAssumptionTrueIsTrue() {
        assumeTrue("Samson".equalsIgnoreCase(System.getenv("USERNAME")));
        assumeTrue("amd64".equalsIgnoreCase(System.getenv("PROCESSOR_ARCHITECTURE")));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindowsOS() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJRE12() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeOnJRE8() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Samson")
    void testIfUserSamson() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Annet")
    void testIfUserAnnet() {
    }
}