package com.rubyExtranet.service.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rubyExtranet.model.user.User;
import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.model.user.UserUpdateForm;

public interface UserService {
	//kielczewski class down here
	Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);
    
    // Add Method to modifing a User ( not able to use JPARepository.save() method to update parameter User)
    @Modifying
    @Query("update User u set u.firstname = ?1, u.lastname = ?2, u.email = ?3 where u.id = ?4")
    void updateUserv3(String firstname, String lastname, String email, long id, User user) ;
    
    User updateUserv2(User user);
    
	//void updateUser(User user);
    //that emethod is use
    User updateUser(UserUpdateForm form, Integer id);
    
	void deleteUser(int id);
    
    //Websystique class down here
    User findById(long id);
    
    User findBySso(String sso);
}
