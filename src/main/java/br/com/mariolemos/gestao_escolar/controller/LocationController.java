package br.com.mariolemos.gestao_escolar.controller;

import br.com.mariolemos.gestao_escolar.controller.dto.request.LocationRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.response.LocationResponse;
import br.com.mariolemos.gestao_escolar.model.Location;
import br.com.mariolemos.gestao_escolar.service.ILocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("location")
@RequiredArgsConstructor
public class LocationController{

    private final ILocationService<Location> service;
    private final LocationRequest locationRequest = new LocationRequest();
    private final LocationResponse locationResponse = new LocationResponse();

    @PreAuthorize("hasAuthority('LOCATION:VIEW')")
    @GetMapping("/{vehicleId}")
    public LocationResponse getLocation(@PathVariable UUID vehicleId){
        return locationResponse.to(service.findByLocation(vehicleId));
    }

    @PostMapping
    public LocationResponse create(@RequestBody LocationRequest request) throws Exception {
        return locationResponse.to(service.create(locationRequest.to(request)));
    }

}
