package com.github.dev.inventory.controller.interfaces;

import com.github.dev.inventory.entity.Conveyor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/v1/conveyors")
@Tag(name = "Consult the conveyors.")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface IConveyorController {

    @Operation(summary = "Save a new conveyor in the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "If registration is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            [
                                              {
                                                "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                                "nameConveyor": "string",
                                                "address": {
                                                  "country": "BR",
                                                  "state": "BR-SP",
                                                  "city": "São Paulo",
                                                  "district": "Moema",
                                                  "street": "Plaza Avenue",
                                                  "number": "100",
                                                  "complement": "BL 02 AP 31",
                                                  "reference": "Yellow House",
                                                  "formattedAddress": "Plaza Avenue, 100, BL 02 AP 31, Moema - São Paulo, SP - Brazil",
                                                  "postalCode": "20111-000"
                                                },
                                                "corporateData": {
                                                  "subscription": "string",
                                                  "contact": "string",
                                                  "telephone": "string",
                                                  "cnpj": "string"
                                                }
                                              }
                                            ]
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-01-27 15:49:56",
                                              "error": "Bad Request",
                                              "status": 400,
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )
    })
    @RequestBody(
            description = """
                    Data to save a new conveyor.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    [
                                      {
                                        "nameConveyor": "string",
                                        "address": {
                                          "country": "BR",
                                          "state": "BR-SP",
                                          "city": "São Paulo",
                                          "district": "Moema",
                                          "street": "Plaza Avenue",
                                          "number": "100",
                                          "complement": "BL 02 AP 31",
                                          "reference": "Yellow House",
                                          "formattedAddress": "Plaza Avenue, 100, BL 02 AP 31, Moema - São Paulo, SP - Brazil",
                                          "postalCode": "20111-000"
                                        },
                                        "corporateData": {
                                          "subscription": "string",
                                          "contact": "string",
                                          "telephone": "string",
                                          "cnpj": "string"
                                        }
                                      }
                                    ]
                                    """
                    )
            )
    )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Conveyor> save(@RequestBody @Valid final Conveyor conveyor) throws Exception;

    @Operation(summary = "Lists all conveyor saved in the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            [
                                              {
                                                "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                                "nameConveyor": "string",
                                                "address": {
                                                  "country": "BR",
                                                  "state": "BR-SP",
                                                  "city": "São Paulo",
                                                  "district": "Moema",
                                                  "street": "Plaza Avenue",
                                                  "number": "100",
                                                  "complement": "BL 02 AP 31",
                                                  "reference": "Yellow House",
                                                  "formattedAddress": "Plaza Avenue, 100, BL 02 AP 31, Moema - São Paulo, SP - Brazil",
                                                  "postalCode": "20111-000"
                                                },
                                                "corporateData": {
                                                  "subscription": "string",
                                                  "contact": "string",
                                                  "telephone": "string",
                                                  "cnpj": "string"
                                                }
                                              }
                                            ]
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-01-27 15:49:56",
                                              "error": "Bad Request",
                                              "status": 400,
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Conveyor>> findAll(@RequestParam(name = "nameConveyor", required = false) String nameConveyor,
                                                  @RequestParam(name = "country", required = false) String country,
                                                  @RequestParam(name = "state", required = false) String state,
                                                  @RequestParam(name = "city", required = false) String city,
                                                  @RequestParam(name = "district", required = false) String district) throws Exception;

    @Operation(summary = "Locate a conveyor by id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            [
                                              {
                                                "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                                "nameConveyor": "string",
                                                "address": {
                                                  "country": "BR",
                                                  "state": "BR-SP",
                                                  "city": "São Paulo",
                                                  "district": "Moema",
                                                  "street": "Plaza Avenue",
                                                  "number": "100",
                                                  "complement": "BL 02 AP 31",
                                                  "reference": "Yellow House",
                                                  "formattedAddress": "Plaza Avenue, 100, BL 02 AP 31, Moema - São Paulo, SP - Brazil",
                                                  "postalCode": "20111-000"
                                                },
                                                "corporateData": {
                                                  "subscription": "string",
                                                  "contact": "string",
                                                  "telephone": "string",
                                                  "cnpj": "string"
                                                }
                                              }
                                            ]
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-01-27 15:49:56",
                                              "error": "Bad Request",
                                              "status": 400,
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested ID was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-01-27 15:49:56",
                                              "error": "Not Found",
                                              "status": 404,
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Conveyor> findById(@PathVariable UUID id) throws Exception;

    @Operation(summary = "Update a conveyor data.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            [
                                              {
                                                "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                                "nameConveyor": "string",
                                                "address": {
                                                  "country": "BR",
                                                  "state": "BR-SP",
                                                  "city": "São Paulo",
                                                  "district": "Moema",
                                                  "street": "Plaza Avenue",
                                                  "number": "100",
                                                  "complement": "BL 02 AP 31",
                                                  "reference": "Yellow House",
                                                  "formattedAddress": "Plaza Avenue, 100, BL 02 AP 31, Moema - São Paulo, SP - Brazil",
                                                  "postalCode": "20111-000"
                                                },
                                                "corporateData": {
                                                  "subscription": "string",
                                                  "contact": "string",
                                                  "telephone": "string",
                                                  "cnpj": "string"
                                                }
                                              }
                                            ]
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-01-27 15:49:56",
                                              "error": "Bad Request",
                                              "status": 400,
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested ID was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-01-27 15:49:56",
                                              "error": "Not Found",
                                              "status": 404,
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )
    })
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Conveyor> update(@RequestBody @Valid final Conveyor conveyor, @PathVariable UUID id) throws Exception;

    @Operation(summary = "Delete a conveyor by id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "If the deletion is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            Record 1fb6fc6e-6e64-40a2-8b94-7e3299231fad deleted from database.
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-01-27 15:49:56",
                                              "error": "Bad Request",
                                              "status": 400,
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested ID was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-01-27 15:49:56",
                                              "error": "Not Found",
                                              "status": 404,
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )

    })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> delete(@PathVariable UUID id) throws Exception;

}
