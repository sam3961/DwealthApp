package com.android.dwealthapp.model.client;

import java.util.List;

public class Client {

    /**
     * id : 099961da-7f41-4309-950f-2b51689a0033
     * create_date : 2017-01-03T00:00:00.000+0000
     * update_date : 2018-02-23T18:29:09.000+0000
     * email : jd@email.com
     * username : jd@email.com
     * client_type : individual
     * title : Mrs.
     * first_name : Jane
     * middle_name : Mary
     * last_name : Doe
     * phone_number : 987-765-1244
     * date_of_birth : 1971-12-27
     * identification_number : 123-44-5566
     * country_of_residence : US
     * is_verified : true
     * hydro_id : 10lm4nz
     * is_active : true
     * metadata : {"median_household_income":"10000","net_worth":"100000","occupation":"Business Owner","zillow_home_value":"450000","annual_income":"70000"}
     * address : [{"address_line1":"3 Downtown Street","address_line2":"","city":"New York","type":"Home","postalcode":"01191","country":"US","state":"NY"}]
     */

    private String id;
    private String create_date;
    private String update_date;
    private String email;
    private String username;
    private String client_type;
    private String title;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String phone_number;
    private String date_of_birth;
    private String identification_number;
    private String country_of_residence;
    private boolean is_verified;
    private String hydro_id;
    private boolean is_active;
    private MetadataBean metadata;
    private List<AddressBean> address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
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

    public String getClient_type() {
        return client_type;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getCountry_of_residence() {
        return country_of_residence;
    }

    public void setCountry_of_residence(String country_of_residence) {
        this.country_of_residence = country_of_residence;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getHydro_id() {
        return hydro_id;
    }

    public void setHydro_id(String hydro_id) {
        this.hydro_id = hydro_id;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public MetadataBean getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataBean metadata) {
        this.metadata = metadata;
    }

    public List<AddressBean> getAddress() {
        return address;
    }

    public void setAddress(List<AddressBean> address) {
        this.address = address;
    }

    public static class MetadataBean {
        /**
         * median_household_income : 10000
         * net_worth : 100000
         * occupation : Business Owner
         * zillow_home_value : 450000
         * annual_income : 70000
         */

        private String median_household_income;
        private String net_worth;
        private String occupation;
        private String zillow_home_value;
        private String annual_income;

        public String getMedian_household_income() {
            return median_household_income;
        }

        public void setMedian_household_income(String median_household_income) {
            this.median_household_income = median_household_income;
        }

        public String getNet_worth() {
            return net_worth;
        }

        public void setNet_worth(String net_worth) {
            this.net_worth = net_worth;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getZillow_home_value() {
            return zillow_home_value;
        }

        public void setZillow_home_value(String zillow_home_value) {
            this.zillow_home_value = zillow_home_value;
        }

        public String getAnnual_income() {
            return annual_income;
        }

        public void setAnnual_income(String annual_income) {
            this.annual_income = annual_income;
        }
    }

    public static class AddressBean {
        /**
         * address_line1 : 3 Downtown Street
         * address_line2 :
         * city : New York
         * type : Home
         * postalcode : 01191
         * country : US
         * state : NY
         */

        private String address_line1;
        private String address_line2;
        private String city;
        private String type;
        private String postalcode;
        private String country;
        private String state;

        public String getAddress_line1() {
            return address_line1;
        }

        public void setAddress_line1(String address_line1) {
            this.address_line1 = address_line1;
        }

        public String getAddress_line2() {
            return address_line2;
        }

        public void setAddress_line2(String address_line2) {
            this.address_line2 = address_line2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPostalcode() {
            return postalcode;
        }

        public void setPostalcode(String postalcode) {
            this.postalcode = postalcode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
