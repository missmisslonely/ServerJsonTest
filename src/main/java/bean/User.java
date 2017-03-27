package bean;

/**
 * Created by SissiLi on 2017/3/27.
 */
public class User {
    public String id;
    public String name;
    public int passwords;
    public User(){}
    public User(String id,String name,int passwords){
        this.id = id;
        this.name = name;
        this.passwords = passwords;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPasswords() {
        return passwords;
    }

    public void setPasswords(int passwords) {
        this.passwords = passwords;
    }
}
