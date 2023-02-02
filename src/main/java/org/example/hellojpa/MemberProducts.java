package org.example.hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MemberProducts {

    @Id @GeneratedValue
//    @Column(name = "MEMBER_PRODUCT_ID")
    private Long id;

}
