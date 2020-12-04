package com.linecorp.codetest.codetestv2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linecorp.codetest.codetestv2.model.Item;
import com.linecorp.codetest.codetestv2.model.SaleRecord;

@SpringBootApplication
@RestController
public class CodetestV2Application {

    @RequestMapping("/line/codetest2/sales/{date}")
    public List<SaleRecord> saleRecord(@PathVariable("date") String date) throws InterruptedException {
        List<SaleRecord> result = new ArrayList<>();
        long dateLong = Long.parseLong(date);
        for (int i = 0; i < 10; i++) {
            SaleRecord saleRecord = new SaleRecord();
            saleRecord.setItemId(i * dateLong % 59 + 1);
            saleRecord.setCount(i * 199 % 23 + 1);
            result.add(saleRecord);
        }
        Thread.sleep(100);
        return result;
    }

    @RequestMapping("/line/codetest2/item/{itemId}")
    public Item getItem(@PathVariable("itemId")long itemId) throws InterruptedException {
        Item item = new Item();
        item.setId(itemId);
        item.setPrice(itemId * 199 % 73 + 1);
        Thread.sleep(100);
        return item;
    }

    public static void main(String[] args) {
        SpringApplication.run(CodetestV2Application.class, args);
    }

}
