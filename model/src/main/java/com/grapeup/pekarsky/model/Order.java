package com.grapeup.pekarsky.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@Document(collection = "order")
public class Order {
    @Id
    private BigInteger id;
    @Indexed
    private Long customerId;
    private Long value;
}
