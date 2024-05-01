public class Seller {

    public Seller(String username, String password, String fullName, int age, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.isAdmin = isAdmin;
    }

    public String fullName;
    public String username;
    public int age;
    public String experience;
    public Double salary;
    public String gender;
    public String password;
    public boolean isAdmin;
}
