package br.thullyo.todolist.repository;

import br.thullyo.todolist.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Integer> {

    @Query(value = "SELECT * FROM tb_tools e WHERE :tag IN (SELECT unnest(e.tags))", nativeQuery = true)
    List<Tool> findAllByTag(@Param("tag")String tag);
}
