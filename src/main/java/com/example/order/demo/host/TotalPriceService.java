package com.example.order.demo.host;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TotalPriceService {
    private final TotalPriceRepository totalPriceRepository;

    @Autowired
    public TotalPriceService(TotalPriceRepository totalPriceRepository) {
        this.totalPriceRepository = totalPriceRepository;
    }

    public TotalPrice addTotalPrice(Long tableNum, double price) {
        TotalPrice totalPrice = new TotalPrice( tableNum, price );
        return totalPriceRepository.save(totalPrice);
    }

    public List<TotalPrice> getTotalPriceAllByTableNum(Long tableNum) {
        List<TotalPrice> totalPrice = totalPriceRepository.findAllByTableNum(tableNum);
        return totalPrice != null ? totalPrice : Collections.emptyList();
    }

    @Transactional
    public void deleteTotalPrice(Long tableNum) {
        totalPriceRepository.deleteAllByTableNum(tableNum);
    }
}
