import org.springframework.data.jpa.repository.JpaRepository; 
public interface CloudvendorRepository extends JpaRepository<Cloudvendor, Long> {
    List<Cloudvendor> findbyTitle(String title);
    List<Cloudvendor> findbyCompleted(boolean completed);
    List<Cloudvendor> findbyTitleContaining(String keyword);
    
}
