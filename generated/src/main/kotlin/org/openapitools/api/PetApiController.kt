package org.openapitools.api

import org.openapitools.model.ModelApiResponse
import org.openapitools.model.Pet
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import javax.validation.Valid
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

import kotlin.collections.List
import kotlin.collections.Map

@RestController
@Validated
@RequestMapping("\${api.base-path:/api/v3}")
class PetApiController() {

    @Operation(
        summary = "Add a new pet to the store",
        operationId = "addPet",
        description = """Add a new pet to the store""",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful operation", content = [Content(schema = Schema(implementation = Pet::class))]),
            ApiResponse(responseCode = "400", description = "Invalid input"),
            ApiResponse(responseCode = "422", description = "Validation exception") ],
        security = [ SecurityRequirement(name = "petstore_auth", scopes = [ "write:pets", "read:pets" ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/pet"],
        produces = ["application/json", "application/xml"],
        consumes = ["application/json", "application/xml", "application/x-www-form-urlencoded"]
    )
    fun addPet(@Parameter(description = "Create a new pet in the store", required = true) @Valid @RequestBody pet: Pet): ResponseEntity<Pet> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Deletes a pet",
        operationId = "deletePet",
        description = """delete a pet""",
        responses = [
            ApiResponse(responseCode = "400", description = "Invalid pet value") ],
        security = [ SecurityRequirement(name = "petstore_auth", scopes = [ "write:pets", "read:pets" ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/pet/{petId}"]
    )
    fun deletePet(@Parameter(description = "Pet id to delete", required = true) @PathVariable("petId") petId: kotlin.Long,@Parameter(description = "", `in` = ParameterIn.HEADER) @RequestHeader(value = "api_key", required = false) apiKey: kotlin.String?): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Finds Pets by status",
        operationId = "findPetsByStatus",
        description = """Multiple status values can be provided with comma separated strings""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(array = ArraySchema(schema = Schema(implementation = Pet::class)))]),
            ApiResponse(responseCode = "400", description = "Invalid status value") ],
        security = [ SecurityRequirement(name = "petstore_auth", scopes = [ "write:pets", "read:pets" ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/pet/findByStatus"],
        produces = ["application/json", "application/xml"]
    )
    fun findPetsByStatus(@Parameter(description = "Status values that need to be considered for filter", schema = Schema(allowableValues = ["available", "pending", "sold"], defaultValue = "available")) @Valid @RequestParam(value = "status", required = false, defaultValue = "available") status: kotlin.String): ResponseEntity<List<Pet>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Finds Pets by tags",
        operationId = "findPetsByTags",
        description = """Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(array = ArraySchema(schema = Schema(implementation = Pet::class)))]),
            ApiResponse(responseCode = "400", description = "Invalid tag value") ],
        security = [ SecurityRequirement(name = "petstore_auth", scopes = [ "write:pets", "read:pets" ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/pet/findByTags"],
        produces = ["application/json", "application/xml"]
    )
    fun findPetsByTags(@Parameter(description = "Tags to filter by") @Valid @RequestParam(value = "tags", required = false) tags: kotlin.collections.List<kotlin.String>?): ResponseEntity<List<Pet>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Find pet by ID",
        operationId = "getPetById",
        description = """Returns a single pet""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = Pet::class))]),
            ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            ApiResponse(responseCode = "404", description = "Pet not found") ],
        security = [ SecurityRequirement(name = "petstore_auth", scopes = [ "write:pets", "read:pets" ]),SecurityRequirement(name = "api_key") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/pet/{petId}"],
        produces = ["application/json", "application/xml"]
    )
    fun getPetById(@Parameter(description = "ID of pet to return", required = true) @PathVariable("petId") petId: kotlin.Long): ResponseEntity<Pet> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Update an existing pet",
        operationId = "updatePet",
        description = """Update an existing pet by Id""",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful operation", content = [Content(schema = Schema(implementation = Pet::class))]),
            ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            ApiResponse(responseCode = "404", description = "Pet not found"),
            ApiResponse(responseCode = "422", description = "Validation exception") ],
        security = [ SecurityRequirement(name = "petstore_auth", scopes = [ "write:pets", "read:pets" ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/pet"],
        produces = ["application/json", "application/xml"],
        consumes = ["application/json", "application/xml", "application/x-www-form-urlencoded"]
    )
    fun updatePet(@Parameter(description = "Update an existent pet in the store", required = true) @Valid @RequestBody pet: Pet): ResponseEntity<Pet> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Updates a pet in the store with form data",
        operationId = "updatePetWithForm",
        description = """""",
        responses = [
            ApiResponse(responseCode = "400", description = "Invalid input") ],
        security = [ SecurityRequirement(name = "petstore_auth", scopes = [ "write:pets", "read:pets" ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/pet/{petId}"]
    )
    fun updatePetWithForm(@Parameter(description = "ID of pet that needs to be updated", required = true) @PathVariable("petId") petId: kotlin.Long,@Parameter(description = "Name of pet that needs to be updated") @Valid @RequestParam(value = "name", required = false) name: kotlin.String?,@Parameter(description = "Status of pet that needs to be updated") @Valid @RequestParam(value = "status", required = false) status: kotlin.String?): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "uploads an image",
        operationId = "uploadFile",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = ModelApiResponse::class))]) ],
        security = [ SecurityRequirement(name = "petstore_auth", scopes = [ "write:pets", "read:pets" ]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/pet/{petId}/uploadImage"],
        produces = ["application/json"],
        consumes = ["application/octet-stream"]
    )
    fun uploadFile(@Parameter(description = "ID of pet to update", required = true) @PathVariable("petId") petId: kotlin.Long,@Parameter(description = "Additional Metadata") @Valid @RequestParam(value = "additionalMetadata", required = false) additionalMetadata: kotlin.String?,@Parameter(description = "") @Valid @RequestBody(required = false) body: org.springframework.core.io.Resource?): ResponseEntity<ModelApiResponse> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
