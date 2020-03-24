package by.bsac.repositories;

import by.bsac.domain.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProjectsCrudRepository")
public interface ProjectsCrudRepository extends CrudRepository<Project, Integer> {
}
