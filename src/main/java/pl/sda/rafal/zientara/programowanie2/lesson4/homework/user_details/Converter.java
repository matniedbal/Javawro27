package pl.sda.rafal.zientara.programowanie2.lesson4.homework.user_details;

import java.util.List;

class Converter {

    private UserDetails userDetails;
    private List<String> userData;
    private String name;
    private String age;
    private String mail;
    private String phone;


    Converter(String path) {
        FileOperations data = new FileOperations(path);
        userData = data.getUserData();
        System.out.println(userData);
    }

    UserDetails userDetails() {
        getUserDetails_Inner();
        return userDetails;
    }

    private void getUserDetails_Inner(){
        userDetails = new UserDetails.Builder(getName())
                .age(getAge())
                .mail(getMail())
                .phone(getPhone())
                .build();
    }

    private String getName() {
        return userData.get(0).replace("Name:","").trim();
    }

    private String getAge() {
        return userData.get(1).replace("Age:","").trim();
    }

    private String getMail() {
        return userData.get(2).replace("Email:","").trim();
    }

    private String getPhone() {
        return userData.get(3).replace("Phone:","").trim();
    }


}
