package com.xyyh.lazylob.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_")
public class User extends AbstractPersistable<Long> {

    @Column
    private String name;

    @Column
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String descript;
}
