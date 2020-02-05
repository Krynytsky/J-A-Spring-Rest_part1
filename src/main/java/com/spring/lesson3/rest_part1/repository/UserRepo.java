package com.spring.lesson3.rest_part1.repository;

import com.spring.lesson3.rest_part1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;


//@NamedNativeQuery(name = "serchByEmail", query = "select * from user where name = ?")
public interface UserRepo extends JpaRepository<User,  Integer> {
    //SELECT * FROM User WHERE email = 'email'
    User findByEmail(String email);


    @Query( "select u from User u  where u.name =:email")
    User userFindByEmail(String email);
//    @NamedNativeQuery(name = "serchByEmail")
//    User nativeQuery(String mail);
}
