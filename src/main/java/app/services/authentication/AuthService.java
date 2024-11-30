package app.services.authentication;

import app.models.User;
import app.repositories.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;
    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        try {
            String hashed_password = DigestUtils.sha256Hex(password);
            if(user.getPassword().equals(hashed_password)){
                return user;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
