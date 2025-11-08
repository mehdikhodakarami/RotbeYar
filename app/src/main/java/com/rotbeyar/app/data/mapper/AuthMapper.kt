package com.rotbeyar.app.data.mapper

import com.rotbeyar.app.data.remote.dto.auth.response.CheckUserResponseDto
import com.rotbeyar.app.data.remote.dto.auth.response.RotateRefreshTokenResponseDto
import com.rotbeyar.app.data.remote.dto.auth.response.VerifyPhoneResponseDto
import com.rotbeyar.app.domain.model.Tokens
import com.rotbeyar.app.domain.model.response.CheckUserResponse
import com.rotbeyar.app.domain.model.response.RotateRefreshTokenResponse
import com.rotbeyar.app.domain.model.response.VerifyPhoneResponse

fun CheckUserResponseDto.toDomain(): CheckUserResponse {
    return CheckUserResponse(this.message, this.status,this.code)
}

fun VerifyPhoneResponseDto.toDomain(): VerifyPhoneResponse {
    return VerifyPhoneResponse(this.message, status=this.status,
        tokens = Tokens(this.token, this.refreshToken)
    )

}


fun RotateRefreshTokenResponseDto.toDomain(): RotateRefreshTokenResponse {
    return RotateRefreshTokenResponse(
        token  = Tokens(this.newToken,this.newRefreshToken)


    )
}