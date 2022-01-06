package com.hrms.hrms.business.UserService;

import com.hrms.hrms.core.exceptions.EmailAlreadyInUseException;
import com.hrms.hrms.core.exceptions.PasswordsNotMatchingException;
import com.hrms.hrms.dataAccess.UserRepository.UserRepository;
import com.hrms.hrms.entity.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void validateUserEmailAndPassword(String password, String passwordRepeat, String email){
        if(!password.equals(passwordRepeat)){
            throw new PasswordsNotMatchingException("Passwords are not matching!");
        }
        if(userRepository.findByEmail(email).isPresent()){
            throw new EmailAlreadyInUseException("This email is already taken!");
        }
    }


}
