package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

// This interface when implemented will cause the class to inherit the tag name and
// the default methods in the interface. To use the beforeAll method, it has to be a static method
// so this is resolved by annotating the class with @TestInstance(Lifecycle.PER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("model")
public interface ModelTests {

    @BeforeAll
    default void beforeAll() {
        System.out.println("This is a way of having the same function running for all model tests");
    }

    static boolean isPalindrome(String string) {
        StringBuffer rev = new StringBuffer(string).reverse();
        String revString = rev.toString();
        if (string.equalsIgnoreCase(revString)) {
            return true;
        }
        else {
            return false;
        }
    }
}
