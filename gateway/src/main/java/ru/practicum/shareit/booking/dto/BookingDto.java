package ru.practicum.shareit.booking.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.user.dto.UserDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
	private Long id;
	@NotNull
	@FutureOrPresent
	private LocalDateTime start;
	@NotNull
	@Future
	private LocalDateTime end;
	private ItemDto item;
	private UserDto booker;
	private BookingStatus status;
	private Long itemId;
	private Long bookerId;
}
