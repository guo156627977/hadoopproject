package com.gzq;

/**
 * @author guozhiqiang
 * @description
 * @created 2018-01-07 18:44.
 */
public class LombokTest {
    public static void main(String[] args) {
        User.UserBuilder userBuilder = new User.UserBuilder();
        User user = userBuilder.id(1).age(25).name("guozhiqiang").build();
        String s = user.toString();
        System.out.println("s = " + s);
        String s1 = userBuilder.toString();
        System.out.println("s1 = " + s1);

        User user2 = new User.UserBuilder().id(1).build();
        System.out.println("user2 = " + user2);


        User user1 = new User(1,"gzq",25);
        System.out.println("user1 = " + user1);
    }
}
