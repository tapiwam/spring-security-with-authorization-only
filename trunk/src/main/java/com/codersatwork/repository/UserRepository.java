package com.codersatwork.repository;

import com.codersatwork.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

/**
 * @author Saurabh Agrawal
 * @crated Feb 13, 2010
 */
public class UserRepository implements UserDetailsService {

    /**
     * {@inheritDoc}
     *
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     * @throws DataAccessException
     */
    public User loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {

        //load user details from database
        //for example User user=userDao.getUserDetails(userName);


        //just for example only : create user mannually here

        if ("Saurabh".equalsIgnoreCase(userName)) {
            User user = new User(userName, true, true, true, true, new GrantedAuthority[]{new GrantedAuthorityImpl("PRIVILEGE_HOME")});
            return user;

        } else {
            User user = new User(userName, true, true, true, true, new GrantedAuthority[]{new GrantedAuthorityImpl("PRIVILEGE_NONE")});
            return user;

        }


    }
}
