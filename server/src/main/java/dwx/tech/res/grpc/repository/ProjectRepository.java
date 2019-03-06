package dwx.tech.res.grpc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dwx.tech.res.grpc.entity.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, Long>{

}
