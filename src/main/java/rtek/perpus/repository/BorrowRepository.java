package rtek.perpus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtek.perpus.models.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    long countByStatus(String status);
}
