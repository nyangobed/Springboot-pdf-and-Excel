package com.pos.demo.Entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

}
