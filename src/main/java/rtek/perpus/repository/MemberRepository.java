package rtek.perpus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtek.perpus.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
