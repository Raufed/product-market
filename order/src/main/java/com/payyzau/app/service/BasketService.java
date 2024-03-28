package com.payyzau.app.service;

import com.payyzau.app.repository.BasketRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    private BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }


}
