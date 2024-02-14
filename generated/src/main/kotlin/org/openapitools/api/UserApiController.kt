package org.openapitools.api

import org.openapitools.model.User
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
class UserApiController() {

    @Operation(
        summary = "Create user",
        operationId = "createUser",
        description = """This can only be done by the logged in user.""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = User::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/user"],
        produces = ["application/json", "application/xml"],
        consumes = ["application/json", "application/xml", "application/x-www-form-urlencoded"]
    )
    fun createUser(@Parameter(description = "Created user object") @Valid @RequestBody(required = false) user: User?): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Creates list of users with given input array",
        operationId = "createUsersWithListInput",
        description = """Creates list of users with given input array""",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful operation", content = [Content(schema = Schema(implementation = User::class))]),
            ApiResponse(responseCode = "200", description = "successful operation") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/user/createWithList"],
        produces = ["application/json", "application/xml"],
        consumes = ["application/json"]
    )
    fun createUsersWithListInput(@Parameter(description = "") @Valid @RequestBody(required = false) user: kotlin.collections.List<User>?): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Delete user",
        operationId = "deleteUser",
        description = """This can only be done by the logged in user.""",
        responses = [
            ApiResponse(responseCode = "400", description = "Invalid username supplied"),
            ApiResponse(responseCode = "404", description = "User not found") ]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/user/{username}"]
    )
    fun deleteUser(@Parameter(description = "The name that needs to be deleted", required = true) @PathVariable("username") username: kotlin.String): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Get user by user name",
        operationId = "getUserByName",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = User::class))]),
            ApiResponse(responseCode = "400", description = "Invalid username supplied"),
            ApiResponse(responseCode = "404", description = "User not found") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/user/{username}"],
        produces = ["application/json", "application/xml"]
    )
    fun getUserByName(@Parameter(description = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathVariable("username") username: kotlin.String): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Logs user into the system",
        operationId = "loginUser",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = kotlin.String::class))]),
            ApiResponse(responseCode = "400", description = "Invalid username/password supplied") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/user/login"],
        produces = ["application/xml", "application/json"]
    )
    fun loginUser(@Parameter(description = "The user name for login") @Valid @RequestParam(value = "username", required = false) username: kotlin.String?,@Parameter(description = "The password for login in clear text") @Valid @RequestParam(value = "password", required = false) password: kotlin.String?): ResponseEntity<kotlin.String> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Logs out current logged in user session",
        operationId = "logoutUser",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/user/logout"]
    )
    fun logoutUser(): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Update user",
        operationId = "updateUser",
        description = """This can only be done by the logged in user.""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation") ]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/user/{username}"],
        consumes = ["application/json", "application/xml", "application/x-www-form-urlencoded"]
    )
    fun updateUser(@Parameter(description = "name that need to be deleted", required = true) @PathVariable("username") username: kotlin.String,@Parameter(description = "Update an existent user in the store") @Valid @RequestBody(required = false) user: User?): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
