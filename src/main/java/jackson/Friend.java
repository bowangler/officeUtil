package jackson;

/**
 * Created by wangb on 2020/4/15.
 */
public class Friend {
    private String nickname;
    private int age;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Friend(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }
}
