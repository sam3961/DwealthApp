package com.android.dwealthapp.model.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterRequest {
    @SerializedName("address")
    @Expose
    private List<Object> address = null;
    @SerializedName("auth_token")
    @Expose
    private String authToken;
    @SerializedName("client_type")
    @Expose
    private String clientType;
    @SerializedName("country_of_residence")
    @Expose
    private String countryOfResidence;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("hydro_id")
    @Expose
    private String hydroId;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("is_verified")
    @Expose
    private Boolean isVerified;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("username")
    @Expose
    private String username;

    public List<Object> getAddress() {
        return address;
    }

    public void setAddress(List<Object> address) {
        this.address = address;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHydroId() {
        return hydroId;
    }

    public void setHydroId(String hydroId) {
        this.hydroId = hydroId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
