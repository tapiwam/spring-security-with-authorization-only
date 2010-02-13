package com.codersatwork.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.AuthenticationException;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.providers.dao.DaoAuthenticationProvider;
import org.springframework.security.userdetails.UserDetails;

/**
 * @author Saurabh Agrawal
 * @crated Feb 13, 2010
 */
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {


    private final Log logger = LogFactory.getLog(this.getClass());

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        logger.info("don't perform any additionalc check as we are not doing any authentication");


        //  super.additionalAuthenticationChecks(userDetails, authentication);


    }
}
