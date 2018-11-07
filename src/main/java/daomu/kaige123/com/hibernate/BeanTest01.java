package daomu.kaige123.com.hibernate;
public class BeanTest01 {


    public BeanTest01() { }

    public BeanTest01(int uid, String address) {
        this.uid = uid;
        this.address = address;
    }

    private int uid;
    private String user;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return "BeanTest01{" +
                "uid=" + uid +
                ", user='" + user + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public BeanTest01(int uid, String user, String address, String phone) {
        this.uid = uid;
        this.user = user;
        this.address = address;
        this.phone = phone;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
