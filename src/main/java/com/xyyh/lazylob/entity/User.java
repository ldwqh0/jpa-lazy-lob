package com.xyyh.lazylob.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import org.hibernate.annotations.LazyGroup;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_")
public class User extends AbstractPersistable<Long> {
    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @LazyGroup("memo")
    private String memo;

}
