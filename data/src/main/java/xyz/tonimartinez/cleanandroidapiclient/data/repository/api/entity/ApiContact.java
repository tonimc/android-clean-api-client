package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity;

import java.util.Date;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public class ApiContact {
    private String gender;
    private ApiContactName name;
    private ApiLocation location;
    private String email;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;
    private Date registered;
    private Date dob;
    private String phone;
    private String cell;
    private String DNI;
    private ApiPicture picture;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ApiContactName getName() {
        return name;
    }

    public void setName(ApiContactName name) {
        this.name = name;
    }

    public ApiLocation getLocation() {
        return location;
    }

    public void setLocation(ApiLocation location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public ApiPicture getPicture() {
        return picture;
    }

    public void setPicture(ApiPicture picture) {
        this.picture = picture;
    }
}
