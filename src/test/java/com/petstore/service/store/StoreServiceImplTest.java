package com.petstore.service.store;

import com.petstore.data.model.Pet;
import com.petstore.data.model.Store;
import com.petstore.data.repository.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoreServiceImplTest {

    @Mock
    StoreRepository storeRepository;

    @InjectMocks
    StoreService storeService = new StoreServiceImpl();

    Store store;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks (this);
        store = new Store();
    }

    @Test
    void testThatWeCanSaveStore () {
        when(storeRepository.save(store)).thenReturn(store);
        storeService.saveStore(store);
        verify(storeRepository, times(1)).save(store);
    }

    @Test
    void testThatWeCanUpdateStore () {
        when(storeRepository.save(store)).thenReturn(store);
        storeService.updateStore(store);
        verify(storeRepository, times(1)).save(store);
    }

    @Test
    void testThatWeCanFindStore () {
        when(storeRepository.findById(2)).thenReturn(Optional.of(store));
        storeService.findStoreById(2);
        verify(storeRepository, times(1)).findById(2);
    }

    @Test
    void testThatWeCanDeleteStoreById () {
        doNothing().when(storeRepository).deleteById(2);
        storeService.deleteStoreById(2);
        verify(storeRepository, times(1)).deleteById(2);
    }

    @Test
    void testThatWeCanFindAllStores () {
        when(storeRepository.findAll()).thenReturn(List.of(store));
        storeService.findAllStores();
        verify(storeRepository, times(1)).findAll();
    }

}