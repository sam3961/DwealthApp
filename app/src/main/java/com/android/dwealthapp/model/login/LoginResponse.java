package com.android.dwealthapp.model.login;

public class LoginResponse {

    /**
     * success : true
     * message : Successful
     * user : {"status":1,"_id":"5c5edd48022b84052726838c","first_name":"aksh","last_name":"null","username":"AKSH","client_type":"individual","email":"akshsh@gmail.com","phone_number":"36989898","date_of_birth":"","address":"","createdOn":1549720904674,"hash":"$2a$10$QEVedb/rFC0DG77o0ukJeewDTW020KSXTLq0vuIVWQW6duDv9LG8S","hydro_id":"f9f42ab4-6797-4eb4-9869-ee3cb7d945a7","createdAt":"2019-02-09T14:01:44.787Z","updatedAt":"2019-02-09T14:01:44.787Z","__v":0,"id":"5c5edd48022b84052726838c"}
     */

    private boolean success;
    private String message;
    private UserBean user;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * status : 1
         * _id : 5c5edd48022b84052726838c
         * first_name : aksh
         * last_name : null
         * username : AKSH
         * client_type : individual
         * email : akshsh@gmail.com
         * phone_number : 36989898
         * date_of_birth :
         * address :
         * createdOn : 1549720904674
         * hash : $2a$10$QEVedb/rFC0DG77o0ukJeewDTW020KSXTLq0vuIVWQW6duDv9LG8S
         * hydro_id : f9f42ab4-6797-4eb4-9869-ee3cb7d945a7
         * createdAt : 2019-02-09T14:01:44.787Z
         * updatedAt : 2019-02-09T14:01:44.787Z
         * __v : 0
         * id : 5c5edd48022b84052726838c
         */

        private int status;
        private String _id;
        private String first_name;
        private String last_name;
        private String username;
        private String client_type;
        private String email;
        private String phone_number;
        private String date_of_birth;
        private String address;
        private long createdOn;
        private String hash;
        private String hydro_id;
        private String createdAt;
        private String updatedAt;
        private int __v;
        private String id;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public long getCreatedOn() {
            return createdOn;
        }

        public void setCreatedOn(long createdOn) {
            this.createdOn = createdOn;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getHydro_id() {
            return hydro_id;
        }

        public void setHydro_id(String hydro_id) {
            this.hydro_id = hydro_id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
