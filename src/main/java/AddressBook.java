import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;


public class AddressBook {

    @JacksonXmlProperty(localName = "Contact")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "contact=" + contacts +
                '}';
    }
}
