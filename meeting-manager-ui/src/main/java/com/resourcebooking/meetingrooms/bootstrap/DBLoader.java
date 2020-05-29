package com.resourcebooking.meetingrooms.bootstrap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.resourcebooking.meetingrooms.entity.Booking;
import com.resourcebooking.meetingrooms.entity.BookingStatus;
import com.resourcebooking.meetingrooms.entity.BookingType;
import com.resourcebooking.meetingrooms.entity.Building;
import com.resourcebooking.meetingrooms.entity.Floor;
import com.resourcebooking.meetingrooms.entity.MeetingRoom;
import com.resourcebooking.meetingrooms.entity.RecursiveBookingType;
import com.resourcebooking.meetingrooms.entity.User;
import com.resourcebooking.meetingrooms.entity.UserRole;
import com.resourcebooking.meetingrooms.repository.BookingRepository;
import com.resourcebooking.meetingrooms.repository.BuildingRepository;
import com.resourcebooking.meetingrooms.repository.FloorRepository;
import com.resourcebooking.meetingrooms.repository.MeetingRoomRepository;
import com.resourcebooking.meetingrooms.repository.UserRepository;

@Component
public class DBLoader implements CommandLineRunner {

	UserRepository userRepository;
	FloorRepository floorRepository;
	BuildingRepository buildingRepository;
	MeetingRoomRepository meetingRoomRepository;
	BookingRepository bookingRepository;
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");

	public DBLoader(UserRepository userRepository, FloorRepository floorRepository,
			BuildingRepository buildingRepository, MeetingRoomRepository meetingRoomRepository,
			BookingRepository bookingRepository) {
		this.buildingRepository = buildingRepository;
		this.userRepository = userRepository;
		this.floorRepository = floorRepository;
		this.meetingRoomRepository = meetingRoomRepository;
		this.bookingRepository = bookingRepository;

	}

	@Override
	public void run(String... args) throws Exception {

		// MEETING ROOMS
		MeetingRoom room1 = new MeetingRoom();
		room1.setName("Lily");
		room1.setCapacity(10);
		room1.setEmail("lily@booking.com");
		room1.setIpPhoneNumber("1234567890");
		room1.setVcEnabled(true);

		MeetingRoom room2 = new MeetingRoom();
		room2.setEmail("lotus@booking.com");
		room2.setName("Lotus");
		room2.setCapacity(4);
		room2.setVcEnabled(false);

		// FLOOR
		Floor floor = new Floor();
		floor.setName("First Floor");
		floor.getRooms().add(room1);
		floor.getRooms().add(room2);
		room1.setFloor(floor);
		room2.setFloor(floor);

		// BUILDING
		Building buildingA = new Building();
		buildingA.setName("TowerA");
		buildingA.getFloors().add(floor);
		floor.setBuilding(buildingA);

		buildingRepository.save(buildingA);

		// USER
		User user1 = new User();
		user1.setName("Kiran");
		user1.setPhone("9561095926");
		user1.setEmailId("kiran.verma.cs@gmail.com");
		user1.setUserRole(UserRole.USER);
		userRepository.save(user1);
		
		
		//BOOKING1
		Booking bookingLily = new Booking();
		bookingLily.setBookingPurpose("Standup");
		bookingLily.setMeetingRoom(room1);
		bookingLily.setOwner(user1);
		bookingLily.setStart(LocalDateTime.now());
		bookingLily.setEnd(LocalDateTime.now().plusHours(1));
		bookingLily.setBookingType(BookingType.OneTime);
		bookingLily.setBookingStaus(BookingStatus.ACTIVE);
		room1.getBooking().add(bookingLily);		
		
		//BOOKING2
		Booking bookingLilyAgain = new Booking();
		bookingLilyAgain.setBookingPurpose("Planning");
		bookingLilyAgain.setMeetingRoom(room1);
		bookingLilyAgain.setOwner(user1);
		bookingLilyAgain.setStart(LocalDateTime.now());
		bookingLilyAgain.setEnd(LocalDateTime.now().plusHours(1));
		bookingLilyAgain.setBookingType(BookingType.OneTime);
		bookingLilyAgain.setBookingStaus(BookingStatus.ACTIVE);
		room1.getBooking().add(bookingLilyAgain);
		
		bookingRepository.save(bookingLily);
		bookingRepository.save(bookingLilyAgain);
		
		//BOOKING3
		Booking bookingLotus = new Booking();
		bookingLotus.setBookingPurpose("Demo");
		bookingLotus.setMeetingRoom(room2);
		bookingLotus.setOwner(user1);
		bookingLotus.setStart(LocalDateTime.now());
		bookingLotus.setEnd(LocalDateTime.now().plusHours(1));
		bookingLotus.setBookingStaus(BookingStatus.ACTIVE);
		bookingLotus.setBookingType(BookingType.Recursive);
		bookingLotus.setReccurBookingType(RecursiveBookingType.DAILY);
		bookingLotus.setOwner(user1);
		room2.getBooking().add(bookingLotus);
		meetingRoomRepository.save(room2);
		bookingRepository.save(bookingLotus);
		
	}

}
