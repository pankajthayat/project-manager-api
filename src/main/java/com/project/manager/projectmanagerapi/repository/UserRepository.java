package com.project.manager.projectmanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.manager.projectmanagerapi.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmployeeId(Long employeeId);
  User deleteByEmployeeId(Long employeeId);

//
//  @Modifying(clearAutomatically = true)
//  @Transactional
//  @Query(value="update user u set u.firstName = :firstName, u.lastName = :lastName where u.employeeId = :employeeId")
//  Object updateUsers(@Param("firstName") String firstName  , @Param("lastName") String lastName, @Param("employeeId") Long employeeId);

//  @Modifying
//  @Query("update users u set u.firstName = ?#{[0]}, u.lastName = ?#{[1]} where u.employeeId=?#{[2]}")
//  public User updateUser(String firstName  , String lastName,  Long employeeId);
}
