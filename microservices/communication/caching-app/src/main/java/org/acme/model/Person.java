package org.acme;

public class Person {
    private Long id;
    private String name;
    private String address;
    private Long age;

    public Person() {
    }

    public Person(Long id, String name, String address, Long age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
