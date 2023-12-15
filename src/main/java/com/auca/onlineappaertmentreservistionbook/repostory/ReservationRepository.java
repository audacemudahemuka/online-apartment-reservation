package com.auca.onlineappaertmentreservistionbook.repostory;

import com.auca.onlineappaertmentreservistionbook.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
