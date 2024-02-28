package com.app.sellerretailreports.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "objects")
public class Obj {
    @Id
    private String id;
    private String string;
}
