package com.example.tidsrejseagenturet.service;

import com.example.tidsrejseagenturet.models.*;
import com.example.tidsrejseagenturet.repositories.*;

import java.util.List;

public class BookingService {
    private final CustomerRepository customerRepo;
    private final TimeMachineRepository timeMachineRepo;
    private final TimePeriodRepository timePeriodRepo;
    private final GuideRepository guideRepo;
    private final BookingRepository bookingRepo;

    public BookingService(CustomerRepository customerRepo, TimeMachineRepository timeMachineRepo, TimePeriodRepository timePeriodRepo, GuideRepository guideRepo, BookingRepository bookingRepo) {
        this.customerRepo = customerRepo;
        this.timeMachineRepo = timeMachineRepo;
        this.timePeriodRepo = timePeriodRepo;
        this.guideRepo =  guideRepo;
        this.bookingRepo = bookingRepo;
    }

    public Booking addBooking(Customer customer, TimeMachine timeMachine, TimePeriod timePeriod, Guide guide) {
        if (customer == null) throw new IllegalArgumentException("Customer must be selected");
        if (timeMachine == null) throw new IllegalArgumentException("TimeMachine must be selected");
        if (timePeriod == null) throw new IllegalArgumentException("TimePeriod must be selected");
        if (guide == null) throw new IllegalArgumentException("Guide must be selected");

        int customerId = customer.getCustomerId();
        int timeMachineId = timeMachine.getId();
        int timePeriodId = timePeriod.getId();
        int guideId = guide.getId();

        Booking booking = new Booking(customerId, timeMachineId, timePeriodId, guideId);
        bookingRepo.addBooking(booking);

        return booking;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.readAllCustomers();
    }

    public List<TimeMachine> getAllTimeMachines(){
        return timeMachineRepo.readAllTimeMachines();
    }

    public List<TimePeriod> getAllTimePeriods(){
        return timePeriodRepo.readAllTimePeriods();
    }

    public List<Guide> getAllGuides(){
        return guideRepo.readAllGuides();
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.readAllBookings();
    }
}
