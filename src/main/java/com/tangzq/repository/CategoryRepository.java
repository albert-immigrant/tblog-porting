package com.tangzq.repository;

import com.tangzq.model.Category;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 栏目文档操作类
 * @author tangzhiqiang
 */
@Repository
//public interface CategoryRepository extends PagingAndSortingRepository<Category,String> {
public interface CategoryRepository extends PagingAndSortingRepository<Category,String> {

    /**
     * 目录名字必须唯一
     * @param catDir 栏目英文目录名称
     * @return
     */

    Category findByid(Long id);
   // List<Category> findByCatDir(String catDir);
   @Query("SELECT c From Category c Where c.catname like %:catname%")
    List<Category> findBycatname(@Param("catname") String Name);
    List<Category> findBycatdir(@Param("catname") String Name);


  //  List<Category> findBycatdir(String catdir);

//    Optional<Category> findById(long parseLong);
    Optional<Category> findById(long parseLong);
}
