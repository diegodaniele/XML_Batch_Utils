package com.diego.springbatch.model;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;


public class FieldSetMapperConverter implements FieldSetMapper<Prodotto> {
    @Override
    public Prodotto mapFieldSet(FieldSet fieldSet) throws BindException {
        Prodotto result = new Prodotto();
        result.setProductName(fieldSet.readString(0));
        result.setPrice(fieldSet.readDouble(1));
        result.setState(fieldSet.readBoolean(2));
        result.setDescription(fieldSet.readString(3));
        result.setQuantity(fieldSet.readInt(4));
        return result;
    }


}