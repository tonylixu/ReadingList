package com.zebra.emc.tools.ReadingList;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Since this extends JpaRepository, there is no need to write and implementation of
 * ReaderRepository. Spring Data JPA will automatically create an implementation of its runtime.
 */
public interface ReaderRepository extends JpaRepository<Reader, String>{

}
