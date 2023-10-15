package com.ecommerce.service;

import com.ecommerce.domain.DeliveryArea;
import com.ecommerce.domain.Store;
import com.ecommerce.exception.DeliveryAreaException;
import com.ecommerce.repository.DeliveryAreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryAreaService {
    private final DeliveryAreaRepository deliveryAreaRepository;

    public DeliveryArea getActiveDeliveryArea(Long deliveryAreaId) {
        return deliveryAreaRepository.findByIdAndActive(deliveryAreaId, true).orElseThrow(() -> new DeliveryAreaException("Delivery area not found!"));
    }

    public DeliveryArea getDeliveryArea(Long deliveryAreaId) {
        return deliveryAreaRepository.findById(deliveryAreaId).orElseThrow(() -> new DeliveryAreaException("Delivery area not found!"));
    }

    public DeliveryArea saveDeliveryArea(Store store, DeliveryArea deliveryArea) {
        if (deliveryAreaExists(store, deliveryArea)) {
            throw new DeliveryAreaException("Delivery area already exists!");
        }
        deliveryArea.setStore(store);
        return deliveryAreaRepository.save(deliveryArea);
    }

    private boolean deliveryAreaExists(Store store, DeliveryArea deliveryArea) {
        return deliveryAreaRepository.existsByStoreAndKilometersDistance(store, deliveryArea.getKilometersDistance());
    }

    public DeliveryArea updateDeliveryArea(Long deliveryAreaId, DeliveryArea deliveryArea) {
        DeliveryArea deliveryAreaEntity = getDeliveryArea(deliveryAreaId);
        deliveryAreaEntity.update(deliveryArea);
        return deliveryAreaRepository.save(deliveryAreaEntity);
    }

    public List<DeliveryArea> getAllActiveDeliveryAreas(Store store) {
        return deliveryAreaRepository.findAllByStoreAndActive(store, true);
    }

    public BigDecimal getPriceDeliveryAreaByKilometerDistance(Double orderKM, Store store) {
        Optional<DeliveryArea> deliveryArea = deliveryAreaRepository.findByKmDistanceAndStore(orderKM, store);
        if (deliveryArea.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return deliveryArea.get().getPrice();
    }

}
