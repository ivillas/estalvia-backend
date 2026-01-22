package cat.estalvia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.estalvia.dto.SupermercatsDTO;
import cat.estalvia.entity.Supermercat;

public interface SupermercatRepository extends JpaRepository<Supermercat, Long> {
}



