package pl.sda.rafal.zientara.programowanie2.lesson4.homework.user_details;

class UserDetails {

    private String name;
    private String age;
    private String mail;
    private String phone;

    private UserDetails(Builder builder) {
       this.name = builder.name;
       this.age = builder.age;
       this.mail = builder.mail;
       this.phone = builder.phone;
    }

    String getName() {
        return name;
    }

    String getAge() {
        return age;
    }

    String getMail() {
        return mail;
    }

    String getPhone() {
        return phone;
    }

    static class Builder{

        private String name;
        private String age;
        private String mail;
        private String phone;

        Builder(String name) {
            this.name = name;
        }

        Builder age(String age){
            this.age = age;
            return this;
        }

        Builder mail(String mail){
            this.mail = mail;
            return this;
        }

        Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        UserDetails build(){
            return new UserDetails(this);
        }
    }

}
