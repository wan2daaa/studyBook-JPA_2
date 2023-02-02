package org.example.hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /** 객체를 데이터 중심 모델링  */

//              //저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("userA");
//            member.setTeamId(team.getId());
//            em.persist(member);
//              //조회
//            Member findMember = em.find(Member.class, member.getId());
//
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            /** 객체를 데이터 중심 모델링  */

            //저장
//            Team teamA = new Team();
//            teamA.setName("TeamA");
//            em.persist(teamA);
//
//            Member member = new Member();
//            member.setUsername("userA");
//            member.setTeam(teamA);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//              //조회
//            Member findMember = em.find(Member.class, member.getId());
//
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam.getName() = " + findTeam.getName());

            /**
             * fetch : EAGER
             *  select
             *         member0_.MEMBER_ID as MEMBER_I1_0_0_,
             *         member0_.TEAM_ID as TEAM_ID3_0_0_,
             *         member0_.USERNAME as USERNAME2_0_0_,
             *         team1_.TEAM_ID as TEAM_ID1_1_1_,
             *         team1_.name as name2_1_1_
             *     from
             *         Member member0_
             *     left outer join
             *         Team team1_
             *             on member0_.TEAM_ID=team1_.TEAM_ID
             *     where
             *         member0_.MEMBER_ID=?
             *
             * fetch : LAZY (join 없이 각각 / N+1 )
             *Hibernate:
             *     select
             *         member0_.MEMBER_ID as MEMBER_I1_0_0_,
             *         member0_.TEAM_ID as TEAM_ID3_0_0_,
             *         member0_.USERNAME as USERNAME2_0_0_
             *     from
             *         Member member0_
             *     where
             *         member0_.MEMBER_ID=?
             * Hibernate:
             *     select
             *         team0_.TEAM_ID as TEAM_ID1_1_0_,
             *         team0_.name as name2_1_0_
             *     from
             *         Team team0_
             *     where
             *         team0_.TEAM_ID=?
             */

            /** 단방향 다대일 */
//            Team teamB = new Team();
//            teamB.setName("TeamA");
//            em.persist(teamB);
//
//            Team findTeamB = em.find(Team.class, "2L");
//            findMember.setTeam(findTeamB);

            /** 양방향 일대다*/
//            Team teamA = new Team();
//            teamA.setName("teamA");
//            em.persist(teamA);
//
//            Member memberA = new Member();
//            memberA.setUsername("memberA");
//            memberA.setTeam(teamA);
//            em.persist(memberA);
//
//            Member findMember = em.find(Member.class, memberA.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member member : members) {
//                System.out.println("member.getUsername() = " + member.getUsername());
//            }

            /** 양방향 매핑시 실수할수 있는 부분
             * 연관관계의 주인이 아닌 Team 에다가 넣으면 DB에 반영 X
             * 연관관계의 주인이 아닌 Team 은 조회만 가능
            */
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("Team1");
//            team.getMembers().add(member);
//            em.persist(team);

            /** JPA 관점 맞는 코드
             * 하지만 객체 관점에서 생각하면 양쪽에 다 넣는게 나음
            */
//            Team team = new Team();
//            team.setName("Team1");
////            team.getMembers().add(member);
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Team team1 = em.find(Team.class, team.getId());
//            List<Member> members = team1.getMembers();
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }





        em.close();
        emf.close();
    }

}
