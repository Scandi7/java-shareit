package ru.practicum.shareit.booking;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.practicum.shareit.booking.dto.BookingDto;
import ru.practicum.shareit.booking.dto.State;


@RestController
@RequestMapping(path = "/bookings")
@RequiredArgsConstructor
@Slf4j
@Validated
public class BookingController {
	private final BookingClient bookingClient;

	@PostMapping
	public ResponseEntity<Object> createBooking(@RequestHeader("X-Sharer-User-Id") Long userId,
												@Valid @RequestBody BookingDto bookingDto) {
		return bookingClient.createBooking(userId, bookingDto);
	}

	@PatchMapping("/{bookingId}")
	public ResponseEntity<Object> approveBooking(@RequestHeader("X-Sharer-User-Id") Long ownerId,
												 @PathVariable Long bookingId,
												 @RequestParam boolean approved) {
		return bookingClient.approveBooking(ownerId, bookingId, approved);
	}

	@GetMapping("/{bookingId}")
	public ResponseEntity<Object> getBookingById(@RequestHeader("X-Sharer-User-Id") Long userId,
												 @PathVariable Long bookingId) {
		return bookingClient.getBookingById(userId, bookingId);
	}

	@GetMapping
	public ResponseEntity<Object> getAllBookings(@RequestHeader("X-Sharer-User-Id") Long userId,
												 @RequestParam(defaultValue = "ALL") State state) {
		return bookingClient.getAllBookings(userId, state);
	}

	@GetMapping("/owner")
	public ResponseEntity<Object> getBookingsForOwner(@RequestHeader("X-Sharer-User-Id") Long ownerId,
													  @RequestParam(defaultValue = "ALL") State state) {
		return bookingClient.getBookingsForOwner(ownerId, state);
	}
}
