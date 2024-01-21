package com.checkin.integration;

import org.springframework.web.bind.annotation.RequestBody;
//import com.CheckIn.integration.dto.Reservation;
//import com.CheckIn.integration.dto.ReservationUpdateRequest;

import com.checkin.integration.dto.Reservation;
import com.checkin.integration.dto.ReservationUpdateRequest;


public interface ReservationRestfulClient {
	public Reservation findReservation(Long id);
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request);
}
