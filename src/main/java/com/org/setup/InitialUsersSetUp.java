package com.org.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class InitialUsersSetUp {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener
    public void onAppSetUp(ApplicationReadyEvent event){
        System.out.println("Came Here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

/*        AllUsers user = new AllUsers(121, "Mohit", passwordEncoder.encode("password"), "mohitashwarya@gmail.com", LocalDate.now() , true, true, true);

        Roles role1 = new Roles("ROLE_ADMIN", "Admin Role");
        Roles role2 = new Roles("ROLE_SUPER", "Super Admin Role");
        Roles role3= new Roles("ROLE_USER", "User Role");

        user.addRoles(role1);
        user.addRoles(role3);

        entityManager.persist(user);
        entityManager.persist(role1);
        entityManager.persist(role2);
        entityManager.persist(role3);*/






    }

}
