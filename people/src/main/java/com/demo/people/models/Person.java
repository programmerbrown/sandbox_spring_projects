package com.demo.people.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PEOPLE")
public class Person {

    @Id
    @GeneratedValue
    private long peopleId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String birthday;

    public Person() {

    }

    public Person(long peopleId, String firstName, String middleName, String lastName, String birthday) {
        this.peopleId = peopleId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(long peopleId) {
        this.peopleId = peopleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
