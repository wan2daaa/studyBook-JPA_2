package org.example.hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    /** 데이터 중심적  */
//    @Column(name = "TEAM_ID")
//    private Long teamId;

    /** EAGER - 즉시 로딩
     *  LAZY
     */
    @ManyToOne(fetch = FetchType.LAZY)
    /** ManyToOne -> JoinColumn ( 연결할 컬럼 ) */
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    /**
     * 연관관계의 주인
     *  양방향 매핑에서 나옴
     *  연관관계의 주인 만이 외래 키를 관리 (등록, 수정)
     *  주인 아닌 쪽은 읽기만 가능
     *  주인 - mappedBy 안씀
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this); //Todo 1. 연관관계 편의 메소드
    }
}