package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * @param petId 
 * @param quantity 
 * @param shipDate 
 * @param status Order Status
 * @param complete 
 */
data class Order(

    @Schema(example = "10", description = "")
    @get:JsonProperty("id") val id: kotlin.Long? = null,

    @Schema(example = "198772", description = "")
    @get:JsonProperty("petId") val petId: kotlin.Long? = null,

    @Schema(example = "7", description = "")
    @get:JsonProperty("quantity") val quantity: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("shipDate") val shipDate: java.time.OffsetDateTime? = null,

    @Schema(example = "approved", description = "Order Status")
    @get:JsonProperty("status") val status: Order.Status? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("complete") val complete: kotlin.Boolean? = null
) {

    /**
    * Order Status
    * Values: placed,approved,delivered
    */
    enum class Status(val value: kotlin.String) {

        @JsonProperty("placed") placed("placed"),
        @JsonProperty("approved") approved("approved"),
        @JsonProperty("delivered") delivered("delivered")
    }

}

