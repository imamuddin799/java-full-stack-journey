package in.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ansari.entity.CourseEntity;

/**
 * Repository interface for performing CRUD and pagination operations on CourseEntity.
 * <p>
 * Extends Spring Data JPA's {@link JpaRepository} to inherit standard data access
 * operations such as save, findById, findAll, delete, and pagination/sorting support.
 * Concrete implementation is provided at runtime by Spring Data based on the
 * method signatures and repository configuration.
 * </p>
 * <p>
 * Type parameters:
 * <ul>
 *   <li>CourseEntity — entity type this repository manages</li>
 *   <li>Integer — type of the entity primary key</li>
 * </ul>
 * </p>
 * <p>
 * Usage: inject this interface into services or controllers to perform database
 * operations on courses without implementing boilerplate DAO code.
 * </p>
 */
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

}