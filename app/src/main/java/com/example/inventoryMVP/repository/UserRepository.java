package com.example.inventoryMVP.repository;

import com.example.inventoryMVP.pojo.User;

import java.util.ArrayList;

/**
 * Created by usuario on 8/11/17.
 */

public class UserRepository {
    private ArrayList<User> users;
    private static UserRepository userRepository;

    /*Inicializar todos los atributos static*/
    static {
        userRepository = new UserRepository();
    }

    private UserRepository(){
        this.users = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        addUser(new User(0, "UltraArmario", "UA!",
                "A Chimo bayo le gusta este armario.", "correo@correo.com", true, false));
        addUser(new User(1, "Armario del Parlament", "España ens roba!",
                "Armario donde se ha aplicado el 155.", "correo@correo.com", true, true));
    }

    public static UserRepository getInstance(){
        if (userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }
    /**
     * Metodo que añade una dependencia
     * @param user
     */
    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getusers(){
        return users;
    }

    public boolean validateCredentials(String user, String password) {
        if ((user == "javi") && password == "1Aaaaa"){
            return true;
        }else{
            return false;
        }
    }
}
