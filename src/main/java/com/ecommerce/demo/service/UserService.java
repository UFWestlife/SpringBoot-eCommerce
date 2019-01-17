package com.ecommerce.demo.service;

import com.ecommerce.demo.bean.UserProfile;
import com.ecommerce.demo.dao.UserDao;
import com.ecommerce.demo.bean.User;
import com.ecommerce.demo.http.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service("UserService")
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;


    // TODO: 2019-01-12 Need to config Security!!! 
//    @Autowired
//    PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;


    
    public List readAllUser() {
        List<User> list = userDao.findAll();
        List printList = new ArrayList();

        for (User user : list) {
            printList.add(user.getId());
            printList.add(user.getUsername());
            printList.add(user.getPassword()+"\n");

        }
        return printList;
    }

//
//    public int updateUser(User user) {
//        user.setAge(18);
//        user.setName("Xin");
//        user.setPassword("321");
//        userDao.save(user);
//        return 0;
//    }




    public Response deleteUser(int id) {
        if(userDao.findById(id).get() != null) {
            userDao.deleteById(id);
            return new Response(true, "User with id="+id+" was deleted successfully.");
        }else {
            return new Response(false, "User is not found!");
        }
    }


    public Response register(User user) {
        try {
            user.setPassword(user.getPassword());

            // TODO: 2019-01-12 Using Security.PasswordEncoder and User profile entity
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            List<UserProfile> profiles = new ArrayList<UserProfile>();
//            profiles.add(new UserProfile(user.getId()));
//            user.setProfiles(profiles);

            userDao.save(user);
//            emailService.sendSimpleMessage(user.getName(), "Account Created", user.getName() +
//                    ", your account is created!");
            String msg = "Account Created: "+user.getUsername()+
                    ", your account is created!";
            return new Response(true, msg);
        }catch (Exception e) {
            LOGGER.error((e.getMessage()));
            return new Response(false, 400, e.getMessage());
        }
    }

    public Response changePassword(User user, Authentication authentication) {
        if(user.getUsername().equals(authentication.getName())/*|| SecurityUtils.isAdmin(authentication.getAuthorities())*/) {
            User u = userDao.findByUsername(user.getUsername());
//            u.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.save(u);
        }else {
            //TODO: Not authorize to update password if not current loggedin user or admin.
            return new Response(false);
        }
        return new Response(true);
    }



}
