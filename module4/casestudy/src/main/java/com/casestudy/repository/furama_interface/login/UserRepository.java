package com.casestudy.repository.furama_interface.login;

import com.casestudy.model.login.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, String> {
    @Query(value = "SELECT * FROM user WHERE user_name = :name ", nativeQuery = true)
    User findByUsername(@Param("name") String name);

    @Modifying
    @Query(value = "INSERT INTO user_role VALUE (:id, :name)", nativeQuery = true)
    void saveUserRole(@Param("id") int id, @Param("name") String name);
}
