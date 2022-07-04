package category.com.exercise_07_category.service.imp;

import category.com.exercise_07_category.model.User;
import category.com.exercise_07_category.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Tìm đối tượng đang đăng nhập trong DB
        User user = this.userRepository.findById(username).orElse(null);

        if (user == null) {
            System.out.println("User not found! " + user);
            throw new UsernameNotFoundException("User " + user + " was not found in the database");
        }
        List<GrantedAuthority> grantList = new ArrayList<>();
        // ROLE_USER, ROLE_ADMIN,..
        GrantedAuthority authority = new SimpleGrantedAuthority("Admin");
        grantList.add(authority);
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                grantList);
        return userDetails;
    }
}
