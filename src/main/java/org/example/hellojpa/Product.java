package org.example.hellojpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

//    @ManyToMany(mappedBy = "products")
//    private List<Member> members = new ArrayList<>();

//    @OneToMany
////    @JoinColumn()
//    private List<MemberProducts> memberProducts = new ArrayList<>();

}
