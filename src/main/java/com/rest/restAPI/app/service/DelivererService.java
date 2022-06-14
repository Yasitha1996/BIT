package com.rest.restAPI.app.service;

import com.rest.restAPI.app.mapping.Customer;
import com.rest.restAPI.app.mapping.Deliverer;
import com.rest.restAPI.app.repo.DelivererRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelivererService {

    @Autowired
    DelivererRepo delivererRepo;

    public Deliverer register(Deliverer deliverer){

        return delivererRepo.save(deliverer);

    }

    public Deliverer login(String username, String password){

        return delivererRepo.findByUsernameAndPassword(username, password);

    }

    public String getDelivererId(String username){

        Deliverer deliverer = delivererRepo.findDelivererByUsername(username);
        String deliverer_id = String.valueOf(deliverer.getDel_id());
        return deliverer_id;
    }

    public boolean alreadyExists(String username) {
        Deliverer deliverer = delivererRepo.findByUsername(username);
        boolean isDeliverer = false;
        try {
            if (deliverer != null) {
                isDeliverer = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return isDeliverer;
    }
}
