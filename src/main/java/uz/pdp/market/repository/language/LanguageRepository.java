package uz.pdp.market.repository.language;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.market.entity.language.Language;
import uz.pdp.market.repository.AbstractRepository;

public interface LanguageRepository extends JpaRepository<Language, Long>, AbstractRepository {
        }
