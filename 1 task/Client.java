public class Client {

    private static int idCounter = 1;
    private int clientId;
    private String organizationName;
    private String typeProperty;
    private String address;
    private String telephone;
    private String contactPerson;

    public Client(String organizationName, String typeProperty,
                  String address, String telephone, String contactPerson) {
        this.clientId = idCounter++;

        this.organizationName = IsValid(organizationName, "Некорректное название организации");
        this.typeProperty = IsValid(typeProperty, "Некорректный вид собственности");
        this.address = validateAddress(address);
        this.telephone = normalizePhone(telephone);
        this.contactPerson = IsValid(contactPerson, "Некорректное контактное лицо");
    }

    private static String IsValid(String value, String errorMessage) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        return value.trim();
    }

    private static String validateAddress(String address) {
        if (address == null || address.trim().isEmpty() || address.trim().length() <= 2) {
            throw new IllegalArgumentException("Некорректный адрес");
        }
        return address.trim();
    }

    private static String normalizePhone(String phone) {
        if (phone == null) {
            throw new IllegalArgumentException("Телефон должен быть введён!");
        }
        phone = phone.replaceAll("[^0-9+]", "");
        if (phone.matches("8\\d{10}")) {
            return phone;
        }
        if (phone.matches("\\+7\\d{10}")) {
            return "8" + phone.substring(2);
        }
        if (phone.matches("\\d{10}")) {
            return "8" + phone;
        }
        throw new IllegalArgumentException("Некорректный формат номера: " + phone);
    }

    public int getClientId() {
        return clientId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = IsValid(organizationName, "Некорректное название организации");
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = IsValid(typeProperty, "Некорректный вид собственности");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = validateAddress(address);
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = normalizePhone(telephone);
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = IsValid(contactPerson, "Некорректное контактное лицо");
    }
}
