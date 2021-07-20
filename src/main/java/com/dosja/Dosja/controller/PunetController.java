package com.dosja.Dosja.controller;


import com.dosja.Dosja.exception.ResourceNotFoundException;
import com.dosja.Dosja.model.Punet;
import com.dosja.Dosja.repository.PunetRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PunetController {

    @Autowired
    PunetRepository punetRep;

   @GetMapping()
    public String index()
    {
        return "<h5>Something you can not afford!</h5>";
    }


    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping("/punet")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Punet> getPunet() {

        return punetRep.findAll();
    }

    @PostMapping("/punet")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public Punet createPune(@Valid @RequestBody(required = true) Punet punet) {
        System.out.println(punet);
        return punetRep.save(punet);

    }

    @GetMapping("/punet/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Punet getPunebyId(@PathVariable(value = "id") Long puneID) {

        return punetRep.findById(puneID)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", puneID));
    }

    @PutMapping("/punet/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Punet updatePunet(@PathVariable(value = "id") Long punaId, @RequestBody Punet punaDetails) {

        Punet punet = punetRep.findById(punaId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", punaId));

        punet.setClient(punaDetails.getClient());
        punet.setCompany(punaDetails.getCompany());
        punet.setDescription(punaDetails.getDescription());
        punet.setMaterial(punaDetails.getMaterial());
        punet.setPrice(punaDetails.getPrice());
        punet.setProduct(punaDetails.getProduct());
        Punet updatedPunet = punetRep.save(punet);
        return updatedPunet;
    }

    @DeleteMapping("/punet/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Punet>  deletePuna(@PathVariable(value = "id") Long punaId) {
        Punet puna = punetRep.findById(punaId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", punaId));

        punetRep.delete(puna);

        return ResponseEntity.ok().build();
    }
}
