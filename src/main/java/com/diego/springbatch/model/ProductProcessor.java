package com.diego.springbatch.model;

import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<Prodotto, Prodotto> {

    private String threadName;

    @Override
    public Prodotto process(Prodotto item) throws Exception {

        System.out.println(" processing : "
                + item.getProductName() + " : " + item.getPrice() + " : " + item.getState() + " : " + item.getDescription() + " : " + item.getQuantity());

        return item;
    }
    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

}
