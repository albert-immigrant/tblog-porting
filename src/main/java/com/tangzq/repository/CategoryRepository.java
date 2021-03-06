package com.tangzq.repository;

import com.tangzq.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 栏目文档操作类
 * @author tangzhiqiang
 */
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,String> {

    /**
     * 目录名字必须唯一
     * @param catDir 栏目英文目录名称
     * @return
     */
    Category findByid(Long id);
   // List<Category> findByCatDir(String catDir);
    List<Category> findByName(String Name);

    List<Category> findBycatdir(String catdir);

    Optional<Category> findById(long parseLong);
}
