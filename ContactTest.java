package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContact() {

        Contact contact = new Contact(
                "123",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertEquals("123", contact.getContactId());
    }

    @Test
    public void testInvalidContactId() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(
                    "12345678901",
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhone() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(
                    "123",
                    "John",
                    "Smith",
                    "12345",
                    "123 Main Street");
        });
    }
}
