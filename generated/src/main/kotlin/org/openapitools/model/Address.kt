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
 * @param street 
 * @param city 
 * @param state 
 * @param zip 
 */
data class Address(

    @Schema(example = "437 Lytton", description = "")
    @get:JsonProperty("street") val street: kotlin.String? = null,

    @Schema(example = "Palo Alto", description = "")
    @get:JsonProperty("city") val city: kotlin.String? = null,

    @Schema(example = "CA", description = "")
    @get:JsonProperty("state") val state: kotlin.String? = null,

    @Schema(example = "94301", description = "")
    @get:JsonProperty("zip") val zip: kotlin.String? = null
) {

}

