package com.example.serverIntelliTestinh.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;

import java.util.HashMap;

public class User {

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("patronymic")
    @Expose
    private String patronymic;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("group")
    @Expose
    private int group;
    @SerializedName("secretQuestion")
    @Expose
    private String secretQuestion;
    @SerializedName("answerOnQuestion")
    @Expose
    private String answerOnQuestion;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("numberPhone")
    @Expose
    private String numberPhone;
    @SerializedName("countItogTest")
    @Expose
    private int countItogTest;
    @SerializedName("blocked")
    @Expose
    private boolean IsBlocked;

    @SerializedName("testIdToGrade")
    @Expose
    private HashMap<String, String> testIdToGrade;

    @SerializedName("role")
    @Expose
    private String role;

    public User(String login, String password, String firstName, String lastName, String patronymic, String birthday,
                int group, String secretQuestion, String answerOnQuestion, String email, String numberPhone,
                int countItogTest, boolean blocked, HashMap<String, String> testIdToGrade, String role) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.group = group;
        this.secretQuestion = secretQuestion;
        this.answerOnQuestion = answerOnQuestion;
        this.email = email;
        this.numberPhone = numberPhone;
        this.countItogTest = countItogTest;
        this.IsBlocked = blocked;
        this.testIdToGrade = testIdToGrade;
        this.role = role;
    }

    public HashMap<String, String> getTestIdToGrade() {
        return testIdToGrade;
    }

    public void setTestIdToGrade(HashMap<String, String> testIdToGrade) {
        this.testIdToGrade = testIdToGrade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getAnswerOnQuestion() {
        return answerOnQuestion;
    }

    public void setAnswerOnQuestion(String answerOnQuestion) {
        this.answerOnQuestion = answerOnQuestion;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Integer getCountItogTest() {
        return countItogTest;
    }

    public void setCountItogTest(Integer countItogTest) {
        this.countItogTest = countItogTest;
    }

    public Boolean getBlocked() {
        return IsBlocked;
    }

    public void setBlocked(Boolean blocked) {
        this.IsBlocked = blocked;
    }

    public void setAllNull()
    {
        this.login = null;
        this.password = null;
        this.firstName = null;
        this.lastName = null;
        this.patronymic = null;
        this.birthday = null;
        this.group = -1;
        this.secretQuestion = null;
        this.answerOnQuestion = null;
        this.email = null;
        this.numberPhone = null;
        //this.icon = icon;
        this.countItogTest = 0;
        this.IsBlocked = false;
        //this.role = Role.USER;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}