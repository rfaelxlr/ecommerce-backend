package com.ecommerce.controller;

import com.ecommerce.controller.vo.CreateStoreRequest;
import com.ecommerce.controller.vo.UpdateStoreRequest;
import com.ecommerce.domain.Store;
import com.ecommerce.service.StoreService;
import com.ecommerce.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
@AllArgsConstructor
public class StoreController {
    private final StoreService storeService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<?> getAllStores() {
        return ResponseEntity.ok(storeService.getAllActiveStores());
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<?> getStore(@PathVariable Long storeId) {
        return ResponseEntity.ok(storeService.getStore(storeId));
    }

    @PostMapping
    public ResponseEntity<?> createStore(@RequestBody @Valid CreateStoreRequest request) {
        Store store = mapperUtil.convert(request, Store.class);
        return ResponseEntity.ok(storeService.createStore(store));
    }

    @PatchMapping("/{storeId}")
    public ResponseEntity<?> updateStore(@PathVariable Long storeId, @RequestBody @Valid UpdateStoreRequest request) {
        Store updatedStore = mapperUtil.convert(request, Store.class);
        return ResponseEntity.ok(storeService.updateStore(storeId, updatedStore));
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<?> deleteStore(@PathVariable Long storeId) {
        storeService.deleteStore(storeId);
        return ResponseEntity.noContent().build();
    }
}
