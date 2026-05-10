package in.ansari.runner;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ansari.entity.CourseEntity;
import in.ansari.entity.EnquiryStatusEntity;
import in.ansari.repository.CourseRepository;
import in.ansari.repository.EnquiryStatusRepository;

/**
 * Application startup data loader that seeds initial course and enquiry status data.
 * <p>
 * Implementing {@link ApplicationRunner} ensures the {@code run} method is executed
 * after the Spring ApplicationContext is loaded. This component clears existing
 * Course and EnquiryStatus records and inserts a small, predefined set of seed data.
 * </p>
 * <p>
 * Responsibilities:
 * - Provide a lightweight data seeding mechanism for development or initial deployments.
 * - Demonstrate repository usage for batch delete and save operations.
 * </p>
 * <p>
 * Notes:
 * - Deleting all records on every startup may not be appropriate for production
 *   environments. Adjust behavior (for example, guard with a profile or check for existing data)
 *   before deploying to non-development environments.
 * - Persistence operations rely on the injected {@link CourseRepository} and
 *   {@link EnquiryStatusRepository}.
 * </p>
 */

@Component
public class DataLoader implements ApplicationRunner {

	/**
     * Repository for course persistence operations.
     * <p>
     * Injected by Spring; used to delete existing course records and save the seed list.
     * </p>
     */
	@Autowired
	private CourseRepository courseRepository;
	
	/**
     * Repository for enquiry status persistence operations.
     * <p>
     * Injected by Spring; used to delete existing status records and save the seed list.
     * </p>
     */
	@Autowired
	private EnquiryStatusRepository enquiryStatusRepository;
	
	/**
     * Run method invoked after application startup.
     * <p>
     * This implementation:
     * <ol>
     *   <li>Defines arrays of course names and enquiry statuses to seed</li>
     *   <li>Converts those arrays into lists of {@link CourseEntity} and {@link EnquiryStatusEntity}</li>
     *   <li>Deletes all existing records from the corresponding repositories</li>
     *   <li>Saves the newly created seed entities in batch using {@code saveAll}</li>
     * </ol>
     * </p>
     *
     * @param args startup arguments provided by the Spring Boot runtime
     * @throws Exception if any repository or persistence operation fails
     * @implNote Consider adding environment checks or idempotency to avoid destructive behavior
     *           (for example, skipping deletion when running in production).
     */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		String [] courseList = {"Java", "Python", "DevOps", "AWS"};
		String [] statusList = {"NEW", "ENROLLED", "LOST"};
		ArrayList<CourseEntity> courses = new ArrayList<>();
		ArrayList<EnquiryStatusEntity> statuses = new ArrayList<>();
		for(int i = 0; i < courseList.length; i++) {
			CourseEntity course = new CourseEntity();
			course.setCourseName(courseList[i]);
			courses.add(course);
		}
		for(int i = 0; i < statusList.length; i++) {
			EnquiryStatusEntity statusEntity = new EnquiryStatusEntity();
			statusEntity.setStatusName(statusList[i]);
			statuses.add(statusEntity);
		}
		courseRepository.deleteAll();
		enquiryStatusRepository.deleteAll();
		courseRepository.saveAll(courses);
		enquiryStatusRepository.saveAll(statuses);
	}
}