package com.gzq;

/**
 * ${DESCRIPTION}
 *
 * @author guozhiqiang
 * @created 2018-01-07 16:57.
 */
public class Bank {
    private Integer id;
    private String name;
    private String address;

    public Bank() {

    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private Bank(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }

    public static Builder newBank() {
        return new Builder();
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private String address;

        private Builder() {
        }

        public Bank build() {
            return new Bank(this);
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
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        Bank bank = builder.id(1).build();
        System.out.println("bank = " + bank);

    }

}
