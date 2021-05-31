import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Contact {
    @JacksonXmlProperty(localName = "CustomerId")
    private String customerId;

    @JacksonXmlProperty(localName = "CompanyName")
    private String companyName;

    @JacksonXmlProperty(localName = "ContactName")
    private String contactName;

    @JacksonXmlProperty(localName = "ContactTitle")
    private String contactTitle;

    @JacksonXmlProperty(localName = "Address")
    private String address;

    @JacksonXmlProperty(localName = "City")
    private String City;

    @JacksonXmlProperty(localName = "Email")
    private String email;

    @JacksonXmlProperty(localName = "PostalCode")
    private String postalCode;

    @JacksonXmlProperty(localName = "Country")
    private String country;

    @JacksonXmlProperty(localName = "Phone")
    private String phone;

    @JacksonXmlProperty(localName = "Fax")
    private String fax;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
