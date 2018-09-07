package to.kit.data.conversion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import to.kit.data.conversion.entity.KenAll;

/**
 * KenAll repository.
 * @author H.Sasai
 */
public interface KenAllRepository extends JpaRepository<KenAll, String> {
	// nop
}
