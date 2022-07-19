package DTO;

public class MemberDTO {

    @Override
    public String toString() {
        return "회원정보 { " +
                "아이디:" + id +
                ", 비밀번호:" + password +
                ", 이름:" + name + '\'' +
                ", 폰번호:" + phone + '\'' +
                ", 이메일=" + email + '\'' +
                ", 가입날짜=" + regdate + '\'' +
                '}';
    }

    private int id;
    private int password;
    private String name;
    private String phone;
    private String email;
    private String regdate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}
