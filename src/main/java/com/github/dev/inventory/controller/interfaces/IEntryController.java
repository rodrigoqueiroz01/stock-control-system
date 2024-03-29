package com.github.dev.inventory.controller.interfaces;

import com.github.dev.inventory.entity.Entry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
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
@RequestMapping("/v1/entries")
@Tag(name = "Consult the entries.")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface IEntryController {

    @Operation(summary = "Save a new entry in the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "If registration is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                              "conveyor": {
                                                "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                                "nameConveyor": "string",
                                                "address": {
                                                  "country": "string",
                                                  "state": "string",
                                                  "city": "string",
                                                  "district": "string",
                                                  "street": "string",
                                                  "number": 0,
                                                  "complement": "string",
                                                  "reference": "string",
                                                  "formattedAddress": "string",
                                                  "postalCode": "string"
                                                },
                                                "corporateData": {
                                                  "subscription": "string",
                                                  "contact": "string",
                                                  "telephone": "string",
                                                  "cnpj": "string"
                                                }
                                              },
                                              "orderDate": "2023-01-30T13:21:00.466Z",
                                              "dateEntry": "2023-01-30T13:21:00.466Z",
                                              "total": {
                                                "value": 0,
                                                "currency": "string"
                                              },
                                              "freight": {
                                                "value": 0,
                                                "currency": "string"
                                              },
                                              "numberNF": 0,
                                              "tax": {
                                                "value": 0,
                                                "currency": "string"
                                              }
                                            }
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
                    Data to save a new entry.    
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                      "conveyor": {
                                        "nameConveyor": "string",
                                        "address": {
                                          "country": "string",
                                          "state": "string",
                                          "city": "string",
                                          "district": "string",
                                          "street": "string",
                                          "number": 0,
                                          "complement": "string",
                                          "reference": "string",
                                          "formattedAddress": "string",
                                          "postalCode": "string"
                                        },
                                        "corporateData": {
                                          "subscription": "string",
                                          "contact": "string",
                                          "telephone": "string",
                                          "cnpj": "string"
                                        }
                                      },
                                      "orderDate": "2023-01-30T13:21:00.466Z",
                                      "dateEntry": "2023-01-30T13:21:00.466Z",
                                      "total": {
                                        "value": 0,
                                        "currency": "string"
                                      },
                                      "freight": {
                                        "value": 0,
                                        "currency": "string"
                                      },
                                      "numberNF": 0,
                                      "tax": {
                                        "value": 0,
                                        "currency": "string"
                                      }
                                    }
                                    """
                    )
            )
    )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Entry> save(@Valid @RequestBody final Entry entry) throws Exception;

    @Operation(summary = "Lists all entry saved in the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                              "conveyor": {
                                                "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                                "nameConveyor": "string",
                                                "address": {
                                                  "country": "string",
                                                  "state": "string",
                                                  "city": "string",
                                                  "district": "string",
                                                  "street": "string",
                                                  "number": 0,
                                                  "complement": "string",
                                                  "reference": "string",
                                                  "formattedAddress": "string",
                                                  "postalCode": "string"
                                                },
                                                "corporateData": {
                                                  "subscription": "string",
                                                  "contact": "string",
                                                  "telephone": "string",
                                                  "cnpj": "string"
                                                }
                                              },
                                              "orderDate": "2023-01-30T13:21:00.466Z",
                                              "dateEntry": "2023-01-30T13:21:00.466Z",
                                              "total": {
                                                "value": 0,
                                                "currency": "string"
                                              },
                                              "freight": {
                                                "value": 0,
                                                "currency": "string"
                                              },
                                              "numberNF": 0,
                                              "tax": {
                                                "value": 0,
                                                "currency": "string"
                                              }
                                            }
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
    @GetMapping
    ResponseEntity<List<Entry>> findAll() throws Exception;

    @Operation(summary = "Locate a entry by id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                              "conveyor": {
                                                "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                                "nameConveyor": "string",
                                                "address": {
                                                  "country": "string",
                                                  "state": "string",
                                                  "city": "string",
                                                  "district": "string",
                                                  "street": "string",
                                                  "number": 0,
                                                  "complement": "string",
                                                  "reference": "string",
                                                  "formattedAddress": "string",
                                                  "postalCode": "string"
                                                },
                                                "corporateData": {
                                                  "subscription": "string",
                                                  "contact": "string",
                                                  "telephone": "string",
                                                  "cnpj": "string"
                                                }
                                              },
                                              "orderDate": "2023-01-30T13:21:00.466Z",
                                              "dateEntry": "2023-01-30T13:21:00.466Z",
                                              "total": {
                                                "value": 0,
                                                "currency": "string"
                                              },
                                              "freight": {
                                                "value": 0,
                                                "currency": "string"
                                              },
                                              "numberNF": 0,
                                              "tax": {
                                                "value": 0,
                                                "currency": "string"
                                              }
                                            }
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
    @GetMapping("/{id}")
    ResponseEntity<Entry> findById(UUID id) throws Exception;

    @Operation(summary = "Update a entry data.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                              "conveyor": {
                                                "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                                                "nameConveyor": "string",
                                                "address": {
                                                  "country": "string",
                                                  "state": "string",
                                                  "city": "string",
                                                  "district": "string",
                                                  "street": "string",
                                                  "number": 0,
                                                  "complement": "string",
                                                  "reference": "string",
                                                  "formattedAddress": "string",
                                                  "postalCode": "string"
                                                },
                                                "corporateData": {
                                                  "subscription": "string",
                                                  "contact": "string",
                                                  "telephone": "string",
                                                  "cnpj": "string"
                                                }
                                              },
                                              "orderDate": "2023-01-30T13:21:00.466Z",
                                              "dateEntry": "2023-01-30T13:21:00.466Z",
                                              "total": {
                                                "value": 0,
                                                "currency": "string"
                                              },
                                              "freight": {
                                                "value": 0,
                                                "currency": "string"
                                              },
                                              "numberNF": 0,
                                              "tax": {
                                                "value": 0,
                                                "currency": "string"
                                              }
                                            }
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
    @PutMapping("/{id}")
    ResponseEntity<Entry> update(Entry entry, UUID id) throws Exception;

    @Operation(summary = "Delete a entry by id.")
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
    @DeleteMapping("{id}")
    ResponseEntity<Object> deleteById(UUID id) throws Exception;

}
