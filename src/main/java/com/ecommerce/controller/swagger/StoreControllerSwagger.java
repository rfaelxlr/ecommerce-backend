package com.ecommerce.controller.swagger;

import com.ecommerce.controller.vo.CreateStoreRequest;
import com.ecommerce.controller.vo.DeliveryAreaRequest;
import com.ecommerce.controller.vo.UpdateDeliveryAreaRequest;
import com.ecommerce.controller.vo.UpdateStoreRequest;
import com.ecommerce.domain.DeliveryArea;
import com.ecommerce.domain.Store;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface StoreControllerSwagger {

    @Operation(summary = "Get all stores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all stores",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Store.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid resource",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Stores not found",
                    content = @Content)})
    ResponseEntity<?> getAllStores();

    @Operation(summary = "Get store by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get store",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Store.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid resource",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Store not found",
                    content = @Content)})
    ResponseEntity<?> getStore(@PathVariable Long storeId);

    @PostMapping("/{storeId}")
    @Operation(summary = "Create a new store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Store created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Store.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    ResponseEntity<?> createStore(@RequestBody @Valid CreateStoreRequest request);

    @DeleteMapping("/{storeId}")
    @Operation(summary = "Delete a store by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Store deleted"),
            @ApiResponse(responseCode = "404", description = "Store not found")})
    ResponseEntity<?> deleteStore(@PathVariable Long storeId);

    @PatchMapping("/{storeId}")
    @Operation(summary = "Update a store by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Store updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Store.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Store not found",
                    content = @Content)})
    ResponseEntity<?> updateStore(@PathVariable Long storeId, @RequestBody @Valid UpdateStoreRequest request);

    @GetMapping("/{storeId}/delivery-areas")
    @Operation(summary = "Get all delivery areas for a store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all delivery areas",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = DeliveryArea.class)))}),
            @ApiResponse(responseCode = "404", description = "Store not found",
                    content = @Content)})
    ResponseEntity<?> getAllDeliveryAreas(@PathVariable Long storeId);

    @PatchMapping("/{storeId}/delivery-areas/{deliveryAreaId}")
    @Operation(summary = "Update a delivery area for a store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delivery area updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DeliveryArea.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Store or delivery area not found",
                    content = @Content)})
    ResponseEntity<?> updateDeliveryArea(@PathVariable Long storeId, @PathVariable Long deliveryAreaId, @RequestBody @Valid UpdateDeliveryAreaRequest request);

    @PostMapping("/{storeId}/delivery-areas")
    @Operation(summary = "Save a new delivery area for a store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Delivery area saved",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DeliveryArea.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    ResponseEntity<?> saveDeliveryArea(@PathVariable Long storeId, @RequestBody @Valid DeliveryAreaRequest request);
}
