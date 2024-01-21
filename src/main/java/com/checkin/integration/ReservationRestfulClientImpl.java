package com.checkin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//import com.CheckIn.integration.dto.Reservation;
//import com.CheckIn.integration.dto.ReservationUpdateRequest;

import com.checkin.integration.dto.Reservation;
import com.checkin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestfulClientImpl implements ReservationRestfulClient {
	
	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject("http://localhost:8081/flight/reservation/" + id,Reservation.class);
	return reservation;
	}
	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject("http://localhost:8081/flight/reservation", request,Reservation.class);
		return reservation;
	}
}