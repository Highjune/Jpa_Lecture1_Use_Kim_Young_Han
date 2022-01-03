package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 연관관계의 주인이 아님. 매핑된 테이블의 거울일 뿐. 여기에 값을 넣는다고 해서 FK의 값의 변경되지 않는다.
    private List<Order> orders = new ArrayList<>();
}
