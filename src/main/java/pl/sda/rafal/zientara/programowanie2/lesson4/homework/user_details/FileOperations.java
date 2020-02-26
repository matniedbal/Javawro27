package pl.sda.rafal.zientara.programowanie2.lesson4.homework.user_details;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class FileOperations {

    private List<String> userData;
    private String path;

    FileOperations(String path) {
        this.path = path;
        userData = new LinkedList<>();
        loadFile();
    }

    private void loadFile(){
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                userData.add(scanner.nextLine());
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    List<String> getUserData() {
        return userData;
    }

    @Override
    public String toString() {
        return "FileOperations{" +
                "userData=" + userData +
                '}';
    }
}
