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

        if (!validateOrganizationName(organizationName)) {
            throw new IllegalArgumentException("Некорректное название организации");
        }
        if (!validateTypeProperty(typeProperty)) {
            throw new IllegalArgumentException("Некорректный вид собственности");
        }
        if (!validateAddress(address)) {
            throw new IllegalArgumentException("Некорректный адрес");
        }
        if (!validateContactPerson(contactPerson)) {
            throw new IllegalArgumentException("Некорректное контактное лицо");
        }

        this.organizationName = organizationName;
        this.typeProperty = typeProperty;
        this.address = address;
        this.telephone = normalizePhone(telephone);
        this.contactPerson = contactPerson;
    }

    private static boolean validateOrganizationName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private static boolean validateTypeProperty(String type) {
        return type != null && !type.trim().isEmpty();
    }

    private static boolean validateAddress(String addr) {
        return addr != null && addr.length() > 5;
    }

    private static boolean validateContactPerson(String person) {
        return person != null && !person.trim().isEmpty();
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
        if (!validateOrganizationName(organizationName)) {
            throw new IllegalArgumentException("Некорректное название организации");
        }
        this.organizationName = organizationName;
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        if (!validateTypeProperty(typeProperty)) {
            throw new IllegalArgumentException("Некорректный вид собственности");
        }
        this.typeProperty = typeProperty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!validateAddress(address)) {
            throw new IllegalArgumentException("Некорректный адрес");
        }
        this.address = address;
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
        if (!validateContactPerson(contactPerson)) {
            throw new IllegalArgumentException("Некорректное контактное лицо");
        }
        this.contactPerson = contactPerson;
    }
}
