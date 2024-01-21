package com.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checkin.integration.ReservationRestfulClient;
import com.checkin.integration.dto.Reservation;
import com.checkin.integration.dto.ReservationUpdateRequest;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationRestfulClient restClient;
	//http://localhost:9090/checkin/startcheckin
	@RequestMapping("/startcheckin")
	public String startCheckIn() {
		return "startcheckin";	
	}
	//http://localhost:9090/checkin/proceedCheckIn
	@RequestMapping("/proceedCheckIn")
	public String proceedCheckIn(@RequestParam("id") Long id, ModelMap model) {
		Reservation reservation = restClient.findReservation(id);
		model.addAttribute("reservation", reservation);
		return "displayReservation";
	}

	@RequestMapping("/proceedToCheckIn")
	public String proceedToCheckIn(@RequestParam("id") Long id, @RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest request = new ReservationUpdateRequest();
		request.setId(id);
		request.setNumberOfBags(numberOfBags);
		request.setCheckInStatus(true);
		restClient.updateReservation(request);
		return "confirmReservation";
}
}