package com.registration.helper;

import org.springframework.stereotype.Component;

import com.registration.command.RegistrationCommand;
import com.registration.entity.AppUser;
import com.registration.entity.ConformationToken;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegistrationHelper {

	public RegistrationCommand createRegistrationCommand() {
		AppUser user = new AppUser();
		ConformationToken token = new ConformationToken(user);
		return new RegistrationCommand(user, token);
	}
}
