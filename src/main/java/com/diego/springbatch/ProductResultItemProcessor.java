package com.diego.springbatch;
import com.diego.springbatch.model.Prodotto;
import org.springframework.batch.item.ItemProcessor;

public class ProductResultItemProcessor implements ItemProcessor<Prodotto, Prodotto> {
    @Override
    public Prodotto process(Prodotto result) throws Exception {
        System.out.println("DB :" + result);
        // Only return results with state true/false
        if (result.getState() == true) {
            return null;
        }
        return result;
    }

}
