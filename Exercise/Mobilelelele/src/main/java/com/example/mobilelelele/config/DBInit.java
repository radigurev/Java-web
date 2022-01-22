package com.example.mobilelelele.config;

import com.example.mobilelelele.model.entity.User;
import com.example.mobilelelele.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private UserRepository userRepository;

    public DBInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeUsers();
    }
    private void initializeUsers(){
        if(userRepository.count()==0){
            User admin=new User();
            admin.setActive(true);
            admin.setUsername("Admin");
            admin.setPassword("admin");
            userRepository.save(admin);
        }
    }
}
