package com.ecommerce.repository;

import com.ecommerce.domain.DeliveryArea;
import com.ecommerce.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryAreaRepository extends JpaRepository<DeliveryArea, Long> {
    boolean existsByStoreAndKilometersDistance(Store store, Double kilometersDistance);

    Optional<DeliveryArea> findByIdAndActive(Long deliveryAreaId, boolean isActive);

    List<DeliveryArea> findAllByStoreAndActive(Store store, boolean isActive);

    @Query("SELECT da FROM DeliveryArea da WHERE da.kilometersDistance >= ?1 and da.store = ?2 ORDER BY da.kilometersDistance ASC LIMIT 1")
    Optional<DeliveryArea> findByKmDistanceAndStore(Double kilometersDistance, Store store);
}
