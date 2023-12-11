package com.example.order.demo.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/totalPrice")
public class TotalPriceController {
    private final TotalPriceService totalPriceService;

    @Autowired
    public TotalPriceController(TotalPriceService totalPriceService) {
        this.totalPriceService = totalPriceService;
    }


    @GetMapping("/{tableNum}")
    public List<TotalPrice> getTotalPriceAllByTableNum(@PathVariable Long tableNum) {
        return totalPriceService.getTotalPriceAllByTableNum(tableNum);
    }

    @PostMapping
    public TotalPrice addTotalPrice(@RequestBody TotalPriceRequest totalPriceRequest) {
        return totalPriceService.addTotalPrice(totalPriceRequest.getTableNum(), totalPriceRequest.getPrice());
    }

}
