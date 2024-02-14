package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param id 
 * @param username 
 * @param firstName 
 * @param lastName 
 * @param email 
 * @param password 
 * @param phone 
 * @param userStatus User Status
 */
data class User(

    @Schema(example = "10", description = "")
    @get:JsonProperty("id") val id: kotlin.Long? = null,

    @Schema(example = "theUser", description = "")
    @get:JsonProperty("username") val username: kotlin.String? = null,

    @Schema(example = "John", description = "")
    @get:JsonProperty("firstName") val firstName: kotlin.String? = null,

    @Schema(example = "James", description = "")
    @get:JsonProperty("lastName") val lastName: kotlin.String? = null,

    @Schema(example = "john@email.com", description = "")
    @get:JsonProperty("email") val email: kotlin.String? = null,

    @Schema(example = "12345", description = "")
    @get:JsonProperty("password") val password: kotlin.String? = null,

    @Schema(example = "12345", description = "")
    @get:JsonProperty("phone") val phone: kotlin.String? = null,

    @Schema(example = "1", description = "User Status")
    @get:JsonProperty("userStatus") val userStatus: kotlin.Int? = null
) {

}

