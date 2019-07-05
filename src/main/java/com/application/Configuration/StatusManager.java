package com.application.Configuration;

import com.application.Data.Enum.Status;
import com.application.Data.User;
import com.application.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
public class StatusManager {

    @Autowired
    private UserRepo userRepo;

    @Scheduled(fixedRate = 5000)//This fixRate may provoke time deviation up to 5 seconds
    public void manageStatus() {

        for (User user : userRepo.findAll()) {
            if ((user.getTimeStamp() != null) &&
                    (user.getStatus() == Status.ONLINE) &&
                    ((new Date().getTime() - user.getTimeStamp()) >= 5000 * 60)) {
                user.setStatus(Status.AWAY);
                userRepo.save(user);
            }
        }

    }
}
