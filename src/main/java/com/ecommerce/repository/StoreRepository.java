package com.ecommerce.repository;

import com.ecommerce.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByActive(boolean active);

    Optional<Store> findByIdAndActive(Long storeId, boolean isActive);
}
