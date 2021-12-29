package com.myclass.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

//Lớp này cấu hình lấy token từ header trong mỗi request để kiểm tra đăng nhập.
public class AuthFilter extends BasicAuthenticationFilter{

	private UserDetailsService userDetailsService;
	
	public AuthFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse rep, FilterChain chain)
			throws IOException, ServletException {
		
		// lấy thông tin từ header do người dùng gửi lên 
		String AuthorizationHeader = req.getHeader("Authorization");
		//kiểm tra xem token có bất đâu bằng bearer hay không 
		if (AuthorizationHeader != null && !AuthorizationHeader.isEmpty()) {
			String token = AuthorizationHeader.replace("Bearer ", "");
			// giải mã token
			String email = Jwts.parser()
					.setSigningKey("ABCDEF")
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
			// lấy thông tin user từ db 
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);

			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
					userDetails.getAuthorities());
			// set thông tin vào security context
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}

		chain.doFilter(req, rep);
	}
}
