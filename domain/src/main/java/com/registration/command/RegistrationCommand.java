package com.registration.command;

import com.registration.entity.ConformationToken;
import com.registration.entity.AppUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationCommand {

	@Valid
	private AppUser user;

	@Valid
	private ConformationToken token;
}


