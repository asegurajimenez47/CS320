package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);

        assertEquals(contact, service.getContact("1"));
    }

    @Test
    public void testDeleteContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);

        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    public void testDuplicateId() {

        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "1",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        Contact contact2 = new Contact(
                "1",
                "Jane",
                "Doe",
                "0987654321",
                "456 Oak Street");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }
}
