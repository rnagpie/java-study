package study.practice.practice56;

public class AddressDTO { // 클래스 이름 변경: AddressDTO
    private String street;
    private String city;
    private String zipcode;

    public AddressDTO() {} // 생성자 이름 변경: AddressDTO

    public AddressDTO(String street, String city, String zipcode) { // 생성자 이름 변경: AddressDTO
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    @Override
    public String toString() {
        return "AddressDTO{" + // toString() 출력도 변경
               "street='" + street + '\'' +
               ", city='" + city + '\'' +
               ", zipcode='" + zipcode + '\'' +
               '}';
    }
}