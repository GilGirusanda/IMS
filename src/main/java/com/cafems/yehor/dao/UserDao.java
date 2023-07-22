package com.cafems.yehor.dao;

import com.cafems.yehor.POJO.User;
import com.cafems.yehor.wrapper.UserWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(@Param("email") String email);

    List<UserWrapper> getAllUsers();

    List<String> getAllAdmin();

    @Transactional
    @Modifying
    void updateStatus(@Param("status") Boolean status, @Param("id") Integer id);

}
