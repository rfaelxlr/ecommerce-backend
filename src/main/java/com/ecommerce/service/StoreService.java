package com.ecommerce.service;

import com.ecommerce.domain.Store;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<Store> getAllActiveStores() {
        return storeRepository.findAllByActive(true);
    }

    public Store getStore(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(() -> new NotFoundException("Store not Found!"));
    }

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public void deleteStore(Long storeId) {
        Store store = getStore(storeId);
        store.delete();
        storeRepository.save(store);
    }

    public Store updateStore(Long storeId, Store updatedStore) {
        Store store = getStore(storeId);
        store.update(updatedStore);
        storeRepository.save(store);
        return store;
    }

    public Store getActiveStore(Long storeId) {
        return storeRepository.findByIdAndActive(storeId,true).orElseThrow(() -> new NotFoundException("Store not Found!"));
    }
}
