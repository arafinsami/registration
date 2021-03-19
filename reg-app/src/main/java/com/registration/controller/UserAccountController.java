package com.registration.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.registration.command.RegistrationCommand;
import com.registration.helper.RegistrationHelper;
import com.registration.mail.MailConfig;
import com.registration.service.AppUserService;
import com.registration.service.EmailSenderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
@SessionAttributes(names = { UserAccountController.COMMAND_NAME })
public class UserAccountController {

	public static final String COMMAND_NAME = "regCommand";

	public static final String VIEW_REGISTRATION = "registration";

	private final AppUserService appUserService;

	private final EmailSenderService emailSenderService;

	private final RegistrationHelper helper;

	private final MailConfig mailConfig;

	@InitBinder(COMMAND_NAME)
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@GetMapping("/create")
	public String create(Model model) {

		RegistrationCommand regCommand = helper.createRegistrationCommand();

		model.addAttribute(COMMAND_NAME, regCommand);
		return VIEW_REGISTRATION;
	}

	@PostMapping("/save")
	public String save(@ModelAttribute(COMMAND_NAME) @Valid RegistrationCommand regCommand, BindingResult bindingResult,
			Model model, SessionStatus sessionStatus) {

		if (bindingResult.hasErrors()) {
			model.addAttribute(COMMAND_NAME, regCommand);
			return VIEW_REGISTRATION;
		}

		appUserService.save(regCommand.getUser(), regCommand.getToken());

		emailSenderService.sendEmail(mailConfig.mail(regCommand.getUser(), regCommand.getToken()));

		sessionStatus.setComplete();

		return "redirect:/";
	}

}
