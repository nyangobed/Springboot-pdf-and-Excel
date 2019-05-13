package com.pos.demo.Repositories;
import ch.qos.logback.core.net.server.Client;
import com.pos.demo.Entities.pos;
import javafx.geometry.Pos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface  PosRepository extends CrudRepository<pos,Long> {

//    Pos findposById(long id);
    @Override
    void delete(pos pos);
}
