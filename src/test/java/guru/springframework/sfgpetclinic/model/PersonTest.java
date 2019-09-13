package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import guru.springframework.sfgpetclinic.MyPersonRepeatedTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// Tags can be at class or method level annotations.
// You can use these to selectively run tests by tag name.
// Click 'Edit Run/Debug configurations dialog' near the hammer icon to get a screen
// where you can configure tests for a particular tag. Use cases can be within CI builds
// where you may want to run only model tests or controller tests.

//@Tag("model") - instead of identifying the test class with a tag name, we can use
// an interface where we specify the tag name and then this class will implement the
// interface.
class PersonTest implements ModelTests {
    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Samson", "Marikwa");

        // then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Samson"),
                () -> assertEquals(person.getLastName(), "Marikwa"));
    }

    @Test
    void groupedAssertionMsgs() {
        // given
        Person person = new Person(1L, "Samson", "Marikwa");

        // then (using Lambda assertions)
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Samson", "First Name Failed"),
                () -> assertEquals(person.getLastName(), "Marikwa", "Last Name Failed"));
    }

}