package com.amanullah.flyingfish;

public class UserHelperClass {
    String age, gender, area, softDrink;

    public UserHelperClass() {

    }

    public UserHelperClass(String age, String gender, String area, String softDrink) {
        this.age = age;
        this.gender = gender;
        this.area = area;
        this.softDrink = softDrink;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSoftDrink() {
        return softDrink;
    }

    public void setSoftDrink(String area) {
        this.softDrink = softDrink;
    }

}
