package com.authentification.login.repository;


import com.authentification.login.entitiy.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {



     public  User findByEmailId(@Param("email") String email);


    @Transactional

    public List<User> getAllUser();


    @Modifying
    @Query(name = "User.updateStatus")
    void updateStatus(@Param("status") String status, @Param("Id") Long Id);


    @Transactional
    @Modifying
    void updatePasswd(@Param("new_password") String new_password ,@Param("email") String email);


    @Transactional
    List<User> getDemandes();



//    User findByRole(String userRole);


}
