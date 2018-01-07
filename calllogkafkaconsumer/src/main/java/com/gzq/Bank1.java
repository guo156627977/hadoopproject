package com.gzq;

/**
 *
 * @author guozhiqiang
 * @created 2018-01-07 16:57.
 */
public class Bank1 {
    private Integer id;
    private String name;
    private String address;

    public Bank1() {

    }


    public static final class Builder {
        private Integer id;
        private String name;
        private String address;

        private Builder() {
        }

        public static Builder aBank1() {
            return new Builder();
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder but() {
            return aBank1().id(id).name(name).address(address);
        }

        public Bank1 build() {
            Bank1 bank1 = new Bank1();
            bank1.id = this.id;
            bank1.address = this.address;
            bank1.name = this.name;
            return bank1;
        }
    }

    @Override
    public String toString() {
        return "Bank1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Builder builder = Builder.aBank1();
        Bank1 bank1 = builder.id(1).address("beijing").name("icbc").build();
        String s = bank1.toString();
        System.out.println("s = " + s);


    }
}
