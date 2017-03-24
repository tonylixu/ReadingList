package com.zebra.emc.tools.ReadingList;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tony Li Xu on 3/24/2017.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);

}
