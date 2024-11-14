package com.buki.log_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Log {
    @Id
    public Long id;
}
