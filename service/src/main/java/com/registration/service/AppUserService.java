
package com.registration.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.registration.entity.ConformationToken;
import com.registration.entity.AppUser;
import com.registration.repository.ConformationTokenRepository;
import com.registration.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserService {

	private final UserRepository userRepository;

	private final ConformationTokenRepository conformationTokenRepository;

	@Transactional
	public void save(AppUser user, ConformationToken token) {
		userRepository.save(user);
		conformationTokenRepository.save(token);
	}

	public Optional<AppUser> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
