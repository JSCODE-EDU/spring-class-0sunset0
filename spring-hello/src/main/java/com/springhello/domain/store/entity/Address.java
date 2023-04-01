package com.springhello.domain.store.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class Address {

    @Column(name = "address_roadcode")
    private String roadCode;
    @Column(name = "address_detail")
    private String detail;
}
