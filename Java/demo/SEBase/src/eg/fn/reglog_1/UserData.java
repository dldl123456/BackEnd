package eg.fn.reglog_1;

public class UserData {
    private String username;
    private String password;

    public UserData() {
    }

    public UserData(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if ((obj != null) && (obj.getClass() == UserData.class)) {
            UserData userData = (UserData) obj;

            if ((this.getUsername().equals(userData.getUsername()))
                    && (this.getPassword().equals(userData.getPassword())))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "UserData [username=" + username + ", password=" + password + "]";
    }

}
