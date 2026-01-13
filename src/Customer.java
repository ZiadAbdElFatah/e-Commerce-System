public class Customer {
    private String name;
    private String email;
    private String password;
    private String address;
    private int age;
    private double balance;
    private final Cart cart;

    public Customer(String name, String email, String password, String address, int age, Cart cart) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.age = age;
        this.cart = cart;
    }

    public Customer(String name, String email, String password, String address, int age, double balance, Cart cart) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.age = age;
        this.balance = balance;
        this.cart = cart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public void reduceBalance(int amount) {
        this.balance -= amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
