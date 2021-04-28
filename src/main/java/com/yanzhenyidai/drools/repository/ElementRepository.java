package com.yanzhenyidai.drools.repository;

import com.yanzhenyidai.drools.domain.Element;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 15:38
 */
public interface ElementRepository extends JpaRepository<Element, Long> {
}
