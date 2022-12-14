package edu.hanoi.jazz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialAuthenticationException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

@Service("socialUserDetailService")
public class JazzSocialUserDetailService implements SocialUserDetailsService{

    @Autowired
    @Qualifier(value = "jazzUserDetailService")
    private UserDetailsService userDetailsService;

    @Override
    public SocialUserDetails loadUserByUserId(String s) throws UsernameNotFoundException {
        UserDetails user = userDetailsService.loadUserByUsername(s);
        if (user == null) throw new SocialAuthenticationException("No user mapped with social user "+s);

        return new SocialUser(user.getUsername(),user.getPassword(),user.isEnabled()
        ,user.isAccountNonExpired(),user.isCredentialsNonExpired(),user.isAccountNonLocked(),user.getAuthorities());
    }

}
