package com.HotelService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelService.Model.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer>{

}
